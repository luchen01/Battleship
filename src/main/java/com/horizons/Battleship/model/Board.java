package com.horizons.Battleship.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;
import java.util.Map;

@Entity
public class Board {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    private HashMap board;

    @Id
    @GeneratedValue
    private Integer id;

    @Autowired
    public Board(User user){
        this.user = user;
        this.board = new HashMap<>(100);
        Integer row = 1;
        while(row < 11){
            Integer col = 1;
            while(col < 11){
                List location = Arrays.asList(row, col);
                Grid newGrid = new Grid(id);
                board.put(location, newGrid);
                col ++;
            }
            row ++;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map getBoard() {
        return board;
    }

    public void setBoard(HashMap board) {
        this.board = board;
    }
}

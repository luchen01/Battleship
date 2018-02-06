package com.horizons.Battleship.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
//    private Board myShips;
//    private Board attacks;

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Board> boards;

//    public User(String username){
//        this.username = username;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}

package com.horizons.Battleship.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="board")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Board {

    @OneToMany(mappedBy="board", cascade = {CascadeType.ALL})
    private Set<Grid> board;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name="GAME_ID")
//    private Integer game_id;

    @OneToMany(mappedBy="shipOnBoard", cascade = {CascadeType.ALL})
    private Set<Ship> shipOnBoard;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Board(){}
    public Board(User currUser){
        this.user = currUser;
    }
    public Board(Set<Ship> shipOnBoard, Set<Grid> board){
        this.board = board;
        this.shipOnBoard = shipOnBoard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Grid> getBoard() {
        return board;
    }

    public void setBoard(Set<Grid> board) {
        this.board = board;
    }

    public Set<Ship> getShipOnBoard() {
        return shipOnBoard;
    }

    public void setShipOnBoard(Set<Ship> shipOnBoard) {
        this.shipOnBoard = shipOnBoard;
    }

    public void addShip(Ship newShip){
        this.shipOnBoard.add(newShip);
    }

    public Grid findGrid(Board board, Integer row, Integer col) throws RuntimeException{
        Set<Grid> setOfGrid = board.getBoard();
        for(Grid temp : setOfGrid){
            if(temp.getRow() == row && temp.getCol()==col){
                return temp;
            }
        }
        throw new RuntimeException("could not find element!");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

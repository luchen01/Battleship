package com.horizons.Battleship.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    private Integer id;
    private String username;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Board userBoards;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private Board myBoard;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Board getMyBoard() {
//        return myBoard;
//    }
//
//    public void setMyBoard(Board myBoard) {
//        this.myBoard = myBoard;
//    }
}


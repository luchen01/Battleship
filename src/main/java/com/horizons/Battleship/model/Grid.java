package com.horizons.Battleship.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grid {
    @Id
    @GeneratedValue
    private Integer id;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Integer boardId;
    private String status;
    private String isAlive;

    @Autowired
    public Grid(Integer boardId){
        this.boardId = boardId;
        this.status = null;
        this.isAlive = null;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIsAlive(String isAlive) {
        this.isAlive = isAlive;
    }

    public String getStatus() {
        return status;
    }

    public String getIsAlive() {
        return isAlive;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBoard() {
        return boardId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }
}

package com.horizons.Battleship.model;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private boolean isFinished;
    private String winner;
    private Integer userTurn;

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String getWinner() {
        return winner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserTurn() {
        return userTurn;
    }

    public void setUserTurn(Integer userTurn) {
        this.userTurn = userTurn;
    }
}

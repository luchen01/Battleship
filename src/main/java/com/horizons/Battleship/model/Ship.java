package com.horizons.Battleship.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String shipName;

    @OneToMany(mappedBy="ship", cascade = {CascadeType.ALL})
    private Set<Grid> ship;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="BOARD_ID")
    private Board shipOnBoard;

    private boolean isSunk;

    public Ship(){};
    public Ship(Set grids){
        this.ship = grids;
        this.isSunk = false;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Integer getId() {
        return id;
    }

    public String getShipName() {
        return shipName;
    }

    public Set<Grid> getShip() {
        return ship;
    }

    public void setShip(Set<Grid> ship) {
        this.ship = ship;
    }

    public Board getBoard() {
        return shipOnBoard;
    }

    public void setBoard(Board shipOnBoard) {
        this.shipOnBoard = shipOnBoard;
    }

    public boolean addGridToShip(Grid newGrid){
        return this.ship.add(newGrid);
    }
}

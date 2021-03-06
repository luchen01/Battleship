package com.horizons.Battleship.controller;

import com.horizons.Battleship.dao.*;
import com.horizons.Battleship.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class BoardController {
    private BoardDao boardDao;
    private GridDao gridDao;
    private ShipDao shipDao;
    private GameDao gameDao;
    private UserDao userDao;

    @Autowired
    public BoardController(BoardDao boardDao, GridDao gridDao, ShipDao shipDao, GameDao gameDao, UserDao userDao){
        this.boardDao = boardDao;
        this.gridDao = gridDao;
        this.shipDao = shipDao;
        this.gameDao = gameDao;
        this.userDao = userDao;
    }
    
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String index() {

        return "Welcome to Battleship!!!";
    }

    @RequestMapping(path="/createGame", method=RequestMethod.POST)
    public Game createGame(){
        return gameDao.save(new Game());
    }

    @RequestMapping(path="/createNewBoard", method= RequestMethod.POST)
    public Board createNewBoard(@RequestBody Integer userId){
        User currUser = userDao.findById(userId);
        Board newBoard = new Board();
        System.out.print(newBoard.getId());
        Set newSet = new HashSet<>();
        Integer row = 1;
        while(row < 11){
            Integer col = 1;
            while(col < 11){
                Grid newGrid = new Grid(row, col, newBoard);
                newSet.add(newGrid);
                gridDao.save(newGrid);
                col ++;
            }
            row ++;
        }
        newBoard.setBoard(newSet);
        return boardDao.save(newBoard);
    }

    @RequestMapping(path="/getMyBoard", method=RequestMethod.POST)
    public Board getMyBoard(@RequestBody Integer boardId){
//        System.out.println(RequestBody);
        return boardDao.findById(boardId.);
    }


    @RequestMapping(path="/createBoardWithShip", method=RequestMethod.POST)
    public Board createBoardWithShip(@RequestBody Set<Grid> boardGrid,
                                     @RequestBody Set<Ship> shipsOnBoard){
        Board newBoard = new Board(shipsOnBoard, boardGrid);

        return boardDao.save(newBoard);
    }

    @RequestMapping(path="/placeShip/{boardId}/{shipName}", method=RequestMethod.POST)
    public Board placeShip(@RequestBody Set<Integer> gridSets,
                           @PathVariable("boardId") Integer boardId,
                           @PathVariable("shipName") String shipName){

        Ship newShip = shipDao.save(new Ship(shipName));
        Board currBoard = boardDao.findById(boardId);
        newShip.setBoard(currBoard);

        for(Integer gId: gridSets){
            Grid newGrid = gridDao.findById(gId);
            newGrid.setShip(newShip);
            newShip.getShip().add(newGrid);
            gridDao.save(newGrid);
        }
        shipDao.save(newShip);
        currBoard.addShip(newShip);
        return boardDao.save(currBoard);

    }

    @RequestMapping(path="/attack/{boardId}/{row}/{col}", method=RequestMethod.POST)
    public String attack(@PathVariable("row") Integer row,
                         @PathVariable("col") Integer col,
                         @PathVariable("boardId") Integer boardId){
        Board currBoard = boardDao.findById(boardId);
        Grid attackGrid = currBoard.findGrid(currBoard, row, col);
        if(attackGrid.getShip() == null){
            return "You missed";
        } else {
            attackGrid.setAlive(false);
            gridDao.save(attackGrid);
            return "You hit my ship!";
        }
    }

    @RequestMapping(path="/gameStatus/{gameId}", method=RequestMethod.POST)
    public Boolean getGameStatus(@PathVariable("gameId") Integer gameId){
        Game currGame = gameDao.findById(gameId);
        return currGame.isFinished();
    }

    @RequestMapping(path="/turn/{gameId}", method=RequestMethod.POST)
    public User getTurn(@PathVariable("gameId") Integer gameId){
        Game currGame = gameDao.findById(gameId);
        return userDao.findById(currGame.getUserTurn());
    }

}

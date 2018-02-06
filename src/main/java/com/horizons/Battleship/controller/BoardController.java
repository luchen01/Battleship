package com.horizons.Battleship.controller;

import com.horizons.Battleship.dao.BoardDao;
import com.horizons.Battleship.model.Board;
import com.horizons.Battleship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private BoardDao boardDao;

    @Autowired
    public BoardController(BoardDao boardDao){
        this.boardDao = boardDao;
    }
    
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String index() {

        return "Welcome to Battleship!!!";
    }

    @RequestMapping(path="/createBoard", method= RequestMethod.POST)
    public Board createBoard(@RequestBody User user){
        return new Board(user);
    }

    @RequestMapping(path="/placeShip/{ship}/{boardId}", method=RequestMethod.POST)
    public Board placeShip(@RequestBody List grids,
                           @PathVariable("ship") String ship,
                           @PathVariable("boardId") Integer boardId){
        Board currBoard = boardDao.findById(boardId);
        for(int i = 0; i < grids.size(); i++){

        }
        return currBoard;
    }



}

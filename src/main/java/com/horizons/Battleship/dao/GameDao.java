package com.horizons.Battleship.dao;

import com.horizons.Battleship.model.Game;
import com.horizons.Battleship.model.Grid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameDao extends CrudRepository<Game, Integer>{
    public List<Game> findAll();
    public Game findById(Integer id);
    public <S extends Game> S save(S Game);
}

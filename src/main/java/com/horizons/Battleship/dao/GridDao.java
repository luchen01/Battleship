package com.horizons.Battleship.dao;

import com.horizons.Battleship.model.Grid;
import com.horizons.Battleship.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface GridDao extends CrudRepository<Grid, Integer> {
    public List<Grid> findAll();
    public Grid findById(Integer id);
    public <S extends Grid> S save(S Grid);

//    public Grid update(Grid grid, Integer id);


}
package com.horizons.Battleship.dao;

import com.horizons.Battleship.model.Ship;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ShipDao extends CrudRepository<Ship, Integer> {
    public List<Ship> findAll();
    public Ship findById(Integer id);
    public <S extends Ship> S save(S Ship);
//    public Ship update(Ship ship, Integer id);

}
package com.horizons.Battleship.dao;

import com.horizons.Battleship.model.Board;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Transactional
public interface BoardDao extends CrudRepository<Board, Integer> {
    public Board findById(Integer id);
    public <S extends Board> S save(S Board);
//    public Board update(Board board, Integer id);

}

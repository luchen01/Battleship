package com.horizons.Battleship.dao;

import com.horizons.Battleship.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
    public List<User> findAll();
    public User findById(Integer id);
    public <S extends User> S save(S User);

}

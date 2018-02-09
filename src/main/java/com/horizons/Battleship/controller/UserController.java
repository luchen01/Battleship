package com.horizons.Battleship.controller;

import com.horizons.Battleship.dao.UserDao;
import com.horizons.Battleship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @RequestMapping(path="/createUser", method= RequestMethod.POST)
    public User createUser(@RequestBody String username){
        User newUser = new User();
        newUser.setUsername(username);
        return userDao.save(newUser);
    }
}

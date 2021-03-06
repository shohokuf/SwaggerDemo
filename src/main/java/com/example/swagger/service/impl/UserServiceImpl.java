package com.example.swagger.service.impl;

import com.example.swagger.dao.UserDao;
import com.example.swagger.domain.User;
import com.example.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public Long addUser(User user) {
        Long aLong = userDao.addUser(user);
        return aLong;
    }

    @Override
    public Long deleteUser(Long id) {
        Long aLong = userDao.deleteUser(id);
        return aLong;
    }

    @Override
    public Long updateUser(User user) {
        Long aLong = userDao.updateUser(user);
        return aLong;
    }
}

package com.example.swagger.dao;

import com.example.swagger.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User getUserById(@Param("id") Long id);

    List<User> getUserList();

    Long addUser(User user);

    Long deleteUser(Long id);

    Long updateUser(User user);
}

package com.example.swagger.service;

import com.example.swagger.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 通过id 获取 user
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取全部的user
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 添加user
     *
     * @param user
     * @return
     */
    Long addUser(User user);

    /**
     * 删除user
     *
     * @param id
     * @return 返回一个map
     */
    Long deleteUser(Long id);

    /**
     * 更新user
     *
     * @param user
     * @return
     */
    Long updateUser(User user);
}

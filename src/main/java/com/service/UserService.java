package com.service;

import com.entity.User;

import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/8/13  11:28
 */
public interface UserService {
    int addUser(User user);
    int delUser(Integer id);
    List<User> selectAllUsers();
    User getUserById(Integer id);
    int updateUser(User user);
    void deleteBatch(List<Integer> ids);
}

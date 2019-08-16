package com.service.impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/8/13  11:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
     private UserMapper userMapper;


    @Override
    public int   addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUser(Integer id) {
        return userMapper.delUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        userMapper.deleteBatch(ids);
    }
}

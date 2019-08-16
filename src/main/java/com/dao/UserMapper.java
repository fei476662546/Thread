package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/8/13  11:26
 */
public interface UserMapper {
    int addUser(User user);
    int delUser(Integer id);
    List<User> selectAllUsers();
    User getUserById(Integer id);
    int updateUser(User user);
    void deleteBatch(@Param("ids")List<Integer>ids);
}

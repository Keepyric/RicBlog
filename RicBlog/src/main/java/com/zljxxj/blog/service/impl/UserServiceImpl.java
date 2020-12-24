package com.zljxxj.blog.service.impl;

import com.zljxxj.blog.entity.User;
import com.zljxxj.blog.mapper.UserMapper;
import com.zljxxj.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public User insertUser(User user) {
        return null;
    }

    @Override
    public User getUserByNameOrEmail(String str) {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}

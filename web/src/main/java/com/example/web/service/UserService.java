package com.example.web.service;

import com.example.web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public void insertUser(User user) ;
    public List<User> selectAll() throws SQLException, ClassNotFoundException;
    public User getUserByUsernameAndPassword(String userName, String password) ;
}
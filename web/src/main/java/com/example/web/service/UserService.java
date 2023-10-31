package com.example.web.service;

import com.example.web.model.User;

import java.sql.SQLException;

public interface UserService {
public void insertUser(User user) throws SQLException, ClassNotFoundException;

}

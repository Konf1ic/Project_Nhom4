package com.example.web.service;

import com.example.web.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements UserService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerces";
    private String jdbcUsername = "root";
    private String jdbcPassword = "slogoman";

    public UserDAO() {
    }

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    private static final String INSERT_ecommerce_SQL =
            "INSERT INTO ecommerces (username, password, email, position) VALUES (?, ?, ?, ?);";

    @Override
    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ecommerce_SQL);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        System.out.println(user.getEmail());
        preparedStatement.setString(4, user.getPosition());
        preparedStatement.executeUpdate();
        System.out.println("1");
    }
}
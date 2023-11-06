package com.example.web.service;

import com.example.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerces";
    private String jdbcUsername = "root";
    private String jdbcPassword = "18092004";

    public UserDAO() {
    }

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    private static final String INSERT_ecommerce_SQL = "INSERT INTO ecommerces (username, password, email, position) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from ecommerces";

    @Override
    public void insertUser(User user) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ecommerce_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            System.out.println(user.getEmail());
            preparedStatement.setString(4, user.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<User> selectAll() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String phone_number = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            double wage = resultSet.getDouble("wage");
            String position = resultSet.getString("position");
            list.add(new User(id, username, password, email, name, age, phone_number, address, wage, position));
        }
        return list;
    }

    @Override
    public User getUserByUsernameAndPassword(String userName, String password) {
        User userFromDb = null;
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ecommerces where username = ? and password = ?");

            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                userFromDb = new User();

                userFromDb.setUsername(rs.getString("username"));
                userFromDb.setPassword(rs.getString("password"));
                userFromDb.setId(rs.getInt("id"));
                userFromDb.setEmail(rs.getString("email"));
                userFromDb.setName(rs.getString("name"));
                userFromDb.setAge(rs.getInt("age"));
                userFromDb.setPhone_number(rs.getString("phone_number"));
                userFromDb.setAddress(rs.getString("address"));
                userFromDb.setWage(rs.getDouble("wage"));
                userFromDb.setPosition(rs.getString("position"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(userFromDb);
        return userFromDb;
    }
}

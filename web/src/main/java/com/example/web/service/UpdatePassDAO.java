package com.example.web.service;

import com.example.web.model.UpdatePass;

import java.sql.*;

public class UpdatePassDAO implements UpdatePassImpDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/ecommerces";
    private String jdbcUsername = "root";
    private String jdbcPassword = "vanh250204";

    public UpdatePassDAO(){}
        public Connection getConnection()throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }
    public static final String UPDATE_PASS_CUSTOMER ="update ecommerce set password = ?  where username = 'vanh'";


    @Override
    public boolean updatePassCustomer(String updatePass, String username) throws SQLException,ClassNotFoundException{
        boolean passUpdate = true;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASS_CUSTOMER);
        preparedStatement.setString(1,updatePass);
        /*preparedStatement.setString(2,"username");*/
        preparedStatement.executeUpdate();
        return passUpdate;
    }
    @Override
    public UpdatePass findEcommerceByUsername(String editUsername) throws SQLException, ClassNotFoundException {
        String query = "select password from ecommerce where username = 'vanh'";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        UpdatePass updatePass = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            updatePass = new UpdatePass(password);
        }
        return  updatePass;
    }
    public String checkPassword (String username) throws SQLException, ClassNotFoundException {
        String query = "SELECT password FROM ecommerce WHERE username = 'vanh'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        String password = null;
        while (resultSet.next()){
            password = resultSet.getString("password");
        }
        return password;
    }
}

package com.service;

import com.model.Ecommerce;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcommerceDao implements EcommerceIDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerces";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1";

    public EcommerceDao(){}
    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    private static final String UPDATE_STAFF_SQL ="update ecommerces set name = ?, password = ? , email = ?, age= ?, phone_number = ?,address = ?, wage = ? , position = ?  where id = ?";
    private static final  String ADMIN_ADD_STAFF_SQL ="INSERT INTO ecommerces (username,password,email,name,age,phone_number,address,wage) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public List<Ecommerce> searchAccount(String name) throws SQLException, ClassNotFoundException {

        List<Ecommerce> list = new ArrayList<>();
        Connection connection = getConnection();
        String query = "select * from ecommerces where username like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "%" + name + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            String phone_number = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            int wage = resultSet.getInt("wage");
            String position = resultSet.getString("position");
            list.add(new Ecommerce(id,username,password,email,age,phone_number,address,wage,position));
        }
        return list;
    }

    @Override
    public boolean updateStaff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException {
        boolean rowUpdate;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STAFF_SQL);
        preparedStatement.setInt(9,ecommerce.getId());
        preparedStatement.setString(1,ecommerce.getName());
        preparedStatement.setString(2,ecommerce.getPassword());
        preparedStatement.setString(3,ecommerce.getEmail());
        preparedStatement.setInt(4,ecommerce.getAge());
        preparedStatement.setString(5,ecommerce.getPhone_number());
        preparedStatement.setString(6,ecommerce.getAddress());
        preparedStatement.setDouble(7,ecommerce.getWage());
        preparedStatement.setString(8,ecommerce.getPosition());
        rowUpdate = preparedStatement.executeUpdate()>0;
        return rowUpdate;
    }

    @Override
    public void addStaffWithAdmin(Ecommerce ecommerce) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADMIN_ADD_STAFF_SQL);
        preparedStatement.setString(1, ecommerce.getUsername());
        preparedStatement.setString(2, ecommerce.getPassword());
        preparedStatement.setString(3, ecommerce.getEmail());
        preparedStatement.setString(4,ecommerce.getName());
        preparedStatement.setInt(5, ecommerce.getAge());
        preparedStatement.setString(6, ecommerce.getPhone_number());
        preparedStatement.setString(7, ecommerce.getAddress());
        preparedStatement.setInt(8, ecommerce.getWage());
        preparedStatement.executeUpdate();
    }


    @Override
    public Ecommerce findEcommerceById(int editID) throws SQLException, ClassNotFoundException {
        String query = "select * from ecommerces where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1,editID);
        Ecommerce ecommerce = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username  = resultSet.getString("username");
            String password  = resultSet.getString("password");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            String phone_number = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            int wage = resultSet.getInt("wage");
            String position = resultSet.getString("position");
            ecommerce = new Ecommerce(id,username,password,email,age,phone_number,address,wage,position);
        }
        return ecommerce;
    }
}
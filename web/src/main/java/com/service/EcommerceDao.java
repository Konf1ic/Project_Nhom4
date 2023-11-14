package com.service;

import com.model.Ecommerce;
import com.model.Product;

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
    private static final String SUPPLIER_ADD_PRODUCT = "INSERT INTO Product(name,price,describes,image,type,quantity) VALUES(?,?,?,?,?,?)";
    private static final String SUPPLIER_EDIT_PRODUCT = "update Product set  where id = ?,name = ?, price = ?, describes = ?,image = ?,type = ?, quantity = ?";

    @Override
    public List<Product> searchProduct(String useName) throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<>();
        Connection connection = getConnection();
        String query = "select * from Product where name like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,"%" + useName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            System.out.println("co data");
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String describes = resultSet.getString("describes");
            String image = resultSet.getString("image");
            String type = resultSet.getString("type");
            int quantity = resultSet.getInt("quantity");
            list.add(new Product(id,name,price,describes,image,type,quantity));
        }

        return list;
    }

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
    public void supplierAddProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SUPPLIER_ADD_PRODUCT);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDouble(2,product.getPrice());
        preparedStatement.setString(3,product.getDescribes());
        preparedStatement.setString(4,product.getImage());
        preparedStatement.setString(5,product.getType());
        preparedStatement.setInt(6,product.getQuantity());
        preparedStatement.executeUpdate();


    }

    @Override
    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {
        boolean productUpdate;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SUPPLIER_EDIT_PRODUCT);
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setString(4,product.getDescribes());
        preparedStatement.setString(5,product.getImage());
        preparedStatement.setString(6,product.getType());
        preparedStatement.setInt(7,product.getQuantity());
        productUpdate = preparedStatement.executeUpdate()>0;
        return productUpdate;
    }

    @Override
    public Product finProductById(int idProduct) throws SQLException, ClassNotFoundException {
        String query = "select * from Product where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1,idProduct);
        Product product = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String describes = resultSet.getString("describes");
            String image = resultSet.getString("image");
            String type = resultSet.getString("type");
            int quantity = resultSet.getInt("quantity");
            product = new Product(id,name,price,describes,image,type,quantity);
        }
        return product;
    }


}
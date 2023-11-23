package com.example.web.service;

import com.example.web.model.Cart;
import com.example.web.model.Product;
import com.example.web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public void insertUser(User user) ;
    public List<User> selectAll() throws SQLException, ClassNotFoundException;
    public User getUserByUsernameAndPassword(String userName, String password) ;
    void addStaffWithAdmin(User user);
    List<User> searchAccount(String name) throws SQLException, ClassNotFoundException;

    public List<Cart> SelectCart() throws SQLException, ClassNotFoundException;
    public void insertToList(Product product) throws SQLException, ClassNotFoundException;
    public void Them(Product product) throws SQLException, ClassNotFoundException;


    public Product selectProduct(int id) throws SQLException;

    public List<Product> selectAllProduct() throws SQLException, ClassNotFoundException;


    public boolean deleteProduct(int id) throws SQLException;

    public boolean deleteCart(int id);

}
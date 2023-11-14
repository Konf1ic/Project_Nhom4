package com.service;

import com.model.Ecommerce;
import com.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface EcommerceIDAO {
    List<Ecommerce> searchAccount(String name) throws SQLException, ClassNotFoundException;
    Ecommerce findEcommerceById(int id) throws SQLException, ClassNotFoundException;
    boolean updateStaff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;
    void addStaffWithAdmin(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;
    void supplierAddProduct(Product product) throws SQLException, ClassNotFoundException;
    boolean updateProduct(Product product) throws SQLException, ClassNotFoundException;
    Product finProductById(int IdProduct) throws SQLException, ClassNotFoundException;
    List<Product> searchProduct(String useName) throws SQLException, ClassNotFoundException;
}
package com.service;

import com.model.Ecommerce;

import java.sql.SQLException;
import java.util.List;

public interface EcommerceIDAO {
    List<Ecommerce> searchAccount(String name) throws SQLException, ClassNotFoundException;
    Ecommerce findEcommerceById(int id) throws SQLException, ClassNotFoundException;
    boolean updateStaff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;
    void addStaffWithAdmin(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;
}
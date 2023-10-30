package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Ecommerce;

import java.sql.SQLException;
import java.util.List;

public interface EcommerceService {
    void insertAccount_buyer(Ecommerce ecommerce);

    void insertAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;

    void insertAccount_supplier(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;

    List<Ecommerce> searchAccount(String name) throws SQLException, ClassNotFoundException;

    boolean UpDateAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;


    Ecommerce findEcommerceById(int id) throws SQLException, ClassNotFoundException;

    void addStaffWithAdmin(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;

}

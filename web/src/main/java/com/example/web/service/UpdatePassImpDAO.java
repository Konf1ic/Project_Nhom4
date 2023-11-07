package com.example.web.service;

import com.example.web.model.UpdatePass;

import java.sql.SQLException;

public interface UpdatePassImpDAO {
    boolean updatePassCustomer(String updatePass,String username) throws SQLException, ClassNotFoundException;

    UpdatePass findEcommerceByUsername(String editUsername) throws SQLException, ClassNotFoundException;
}

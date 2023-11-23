package com.example.web.controller;

import com.example.web.model.Product;
import com.example.web.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SupplierServlet", value = "/supplier")
public class SupplierServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        switch (action) {
            case "them":
                try {
                    System.out.println("lllll");
                    Them(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                try {
                    listProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Product> list1 = userDAO.selectAllProduct();
        req.setAttribute("lists1", list1);
        req.getRequestDispatcher("/SanPham/nhaCungCap.jsp").forward(req, resp);
    }

    private void Them(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String describes = req.getParameter("describes");
        String image = req.getParameter("image");
        String type = req.getParameter("type");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        userDAO.Them(new Product(name, price, describes, image, type, quantity));
        listProduct(req, resp);

    }
}


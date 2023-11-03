package com.controller;

import com.model.Ecommerce;
import com.service.EcommerceDao;
import com.service.EcommerceIDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EcommerceServlet", value = "/ecommerces")
public class EcommerceServlet extends HttpServlet {
    private EcommerceIDAO ecommerceIDAO = new EcommerceDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "edit":
                    showEditFrom(req, resp);
                    break;
                case "add":
                    showAddFrom(req, resp);
                    break;
                case "search":
                    showSearchForm(req,resp);
                    break;
                case "admin":
                    showAdminPage(req,resp);
                    break;
                default:
                    showHomePage(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void showAdminPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("home_page.jsp").forward(req, resp);
    }

    private void showAddFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("VD_add/adminAddStaff.jsp").forward(req, resp);
    }

    private void showEditFrom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("staff", ecommerceIDAO.findEcommerceById(id));
        req.getRequestDispatcher("VD_update/updateStaff.jsp").forward(req, resp);
    }

    private void showSearchForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("VD_searchAccount/search.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "search":
                    searchAccount(req, resp);
                    break;
                case "edit":
                    updateAccountStaff(req, resp);
                    break;
                case "add":
                    addStaffWithAdmin(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addStaffWithAdmin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone_number = req.getParameter("phone_number");
        String address = req.getParameter("address");
        int wage = Integer.parseInt(req.getParameter("wage"));
        Ecommerce ecommerce = new Ecommerce(username, password, email, name, age, phone_number, address, wage);
        ecommerceIDAO.addStaffWithAdmin(ecommerce);
        req.getRequestDispatcher("VD_adminAddStaff.jsp").forward(req, resp);
    }

    private void updateAccountStaff(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone_number = req.getParameter("phone_number");
        String address = req.getParameter("address");
        int wage = Integer.parseInt(req.getParameter("wage"));
        String position = req.getParameter("position");
        Ecommerce update = new Ecommerce(id, name, password, email, age, phone_number, address, wage, position);
        ecommerceIDAO.updateStaff(update);
        req.getRequestDispatcher("VD_update/updateStaff.jsp");
    }

    private void searchAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = request.getParameter("username");
        List<Ecommerce> list = ecommerceIDAO.searchAccount(username);
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("VD_searchAccount/search.jsp");
        requestDispatcher.forward(request, response);
    }
}
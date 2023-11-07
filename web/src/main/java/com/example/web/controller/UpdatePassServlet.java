package com.example.web.controller;

import com.example.web.service.UpdatePassDAO;
import Service.UpdatePassImpDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name="UpdatePass",value ="/updatepass")
public class UpdatePassServlet extends HttpServlet {
    public static UpdatePassDAO updatePassDAO;
    @Override
    public void init() {
        updatePassDAO = new UpdatePassDAO() ;
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
                switch (action){
                    case"edit":
                        updateComplete(req,resp);
                        break;
                    default:
                        updatePass(req, resp);
                        break;
                }
        }catch (Exception e){
            throw  new RuntimeException();
        }

    }
    private void  updateComplete(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = req.getParameter("username");
        req.setAttribute("customer",updatePassDAO.findEcommerceByUsername(username));
        req.getRequestDispatcher("UpdateComplete.jsp").forward(req,resp);
    }
    private void updatePass(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("UpdatePass.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String username = req.getParameter("username");
        System.out.println(username);
        String oldPassword= req.getParameter("oldpassword");
        String newPassword = req.getParameter("newpassword");
        String confirmPassword = req.getParameter("confirmpassword");

        try {
//           check điều kiện để đổi mật khẩu
             if (oldPassword.equals(updatePassDAO.checkPassword(username))&& !oldPassword.equals(newPassword) && newPassword.equals(confirmPassword) ){
                 updatePassDAO.updatePassCustomer(newPassword,username);
                 updateComplete(req, resp);
            }else {
                 updatePass(req,resp);

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

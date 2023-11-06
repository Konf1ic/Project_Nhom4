package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class SignUp_SignInServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                try {
                    insertUser(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "login":
                login(req, resp);
                break;

        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // Lay nguoi dung
        User userSession = userDAO.getUserByUsernameAndPassword(username, password);
        if (userSession == null) {
            resp.sendRedirect("/signin.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("userSession", userSession);
            String position;
            position = userSession.getPosition();
            switch (position) {
                case "NhanVien":
                    try {
                        req.getRequestDispatcher("home_page2.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                default:
                    // Vi du trang co the hien thi 2 position
                    try {
                        req.getRequestDispatcher("/home_page2.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
            }

        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp)
            throws ClassNotFoundException, ServletException, IOException, SQLException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String position = req.getParameter("position");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPosition(position);
        List<User> list = userDAO.selectAll();
        if (list.isEmpty()) {
            userDAO.insertUser(user);
            req.setAttribute("message", "Sign Up Success ");
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        } else {
            for (User item : list) {
                if (user.getUsername().equals(item.getUsername())) {
                    HttpSession session = req.getSession();
                    session.setAttribute("mess_error", "not available");
                    req.getRequestDispatcher("signup.jsp").forward(req, resp);
                } else {
                    userDAO.insertUser(user);
                    req.setAttribute("message", "Sign Up Success ");
                    req.getRequestDispatcher("signin.jsp").forward(req, resp);
                }
            }
        }
    }
}

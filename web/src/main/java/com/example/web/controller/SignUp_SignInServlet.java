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
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
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
                        req.getRequestDispatcher("home_page2.jsp").forward(req,resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                default:
                    // Vi du trang co the hien thi 2 position
                    try {
                        req.getRequestDispatcher("/sessionDemo.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
            }

        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String position = req.getParameter("position");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPosition(position);
        userDAO.insertUser(user);
        req.setAttribute("message", "Sign Up Success ");
        req.getRequestDispatcher("signin.jsp").forward(req, resp);

    }
<<<<<<< HEAD:web/src/main/java/com/example/web/controller/SignUp_SignInServlet.java

=======
>>>>>>> 9ef41a64e536af3b8b96cd381d4f95cb31a4aead:web/src/main/java/com/example/web/controller/SignUpServlet.java
}

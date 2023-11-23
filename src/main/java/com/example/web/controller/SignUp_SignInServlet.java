package com.example.web.controller;

import com.example.web.model.Cart;
import com.example.web.model.Product;
import com.example.web.model.User;
import com.example.web.service.UserDAO;

import javax.servlet.RequestDispatcher;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                showSearchFrom(req, resp);
                break;
            case "them":
                showFormAdd(req, resp);
                break;
            case "add":
                try {
                    addProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "list":
                try {
                    showCart(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    deleteProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;


        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userDAO.deleteProduct(id);

        listProduct(req, resp);
    }

    private void
    showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/SanPham/addProduct.jsp");
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Cart> list = userDAO.SelectCart();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/SanPham/listCartProduct.jsp").forward(req, resp);
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String describes = req.getParameter("describes");
        String image = req.getParameter("image");
        String type = req.getParameter("type");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        System.out.println(image + type + quantity);

        userDAO.insertToList(new Product(id, name, price, describes, image, type, quantity));

        listProduct(req, resp);

    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Product> list = userDAO.selectAllProduct();
        req.setAttribute("lists", list);
        req.getRequestDispatcher("/SanPham/watch.jsp").forward(req, resp);

    }


    private void showSearchFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("search.jsp").forward(req, resp);
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
            case "add":
                try {
                    addStaffWithAdmin(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    searchAccount(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
//            case "them":
//                try {
//                    Them(req, resp);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
            case "deleteCart":
                try {
                    deleteCart(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));

        userDAO.deleteCart(id);
        showCart(req, resp);


    }

//    private void Them(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        String name = req.getParameter("name");
//        double price = Double.parseDouble(req.getParameter("price"));
//        String describes = req.getParameter("describes");
//        String image = req.getParameter("image");
//        String type = req.getParameter("type");
//        int quantity = Integer.parseInt(req.getParameter("quantity"));
//
//        userDAO.Them(new Product(name, price, describes, image, type, quantity));
//        listProduct(req, resp);
//    }


    private void searchAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String username = req.getParameter("username");
        List<User> list = userDAO.searchAccount(username);
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("search.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addStaffWithAdmin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone_number = req.getParameter("phone");
        String address = req.getParameter("address");
        double wage = Double.parseDouble(req.getParameter("salary"));
        String position = req.getParameter("position");

        User user = new User(username, password, email, name, age, phone_number, address, wage, position);


        userDAO.addStaffWithAdmin(user);
        req.getRequestDispatcher("addStaff.jsp").forward(req, resp);
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
            System.out.println(position);
            switch (position) {
                case "KhachHang":
                    try {
                        req.getRequestDispatcher("khachHang.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "NhanVien":
                    try {
                        req.getRequestDispatcher("nhanVien.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "NhaCungCap":
                    try {
                        List<Product> list = userDAO.selectAllProduct();
                        req.setAttribute("lists", list);
                        req.getRequestDispatcher("/SanPham/nhaCungCap.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "Admin":
                    try {
                        req.getRequestDispatcher("adminHome.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    // Vi du trang co the hien thi 2 position
                    try {
                        req.getRequestDispatcher("/khachHang.jsp").forward(req, resp);
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
        if (list.isEmpty() == false) {
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

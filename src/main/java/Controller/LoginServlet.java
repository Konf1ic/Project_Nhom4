package Controller;

import Model.Login;
import Service.DBConnect;
import Service.EcommerceDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Thông tin kết nối cơ sở dữ liệu
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerces";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "vanh250204";
    DBConnect dbConnect = new DBConnect();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // Kiểm tra thông tin đăng nhập
        if (isValidLogin(username, password)) {
            // Tạo session và lưu thông tin người dùng
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Chuyển hướng đến trang chính

            try {
                Statement statement = dbConnect.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select position from ecommerce");
                while (resultSet.next()) {
                    String role = resultSet.getString("position");


                    switch (role) {
                        case "admin":
                            request.getRequestDispatcher("admin.jsp").forward(request,response);
                        case " supplier":
                            request.getRequestDispatcher("supplier.jsp").forward(request,response);
                        case "customer":
                            request.getRequestDispatcher("customer.jsp").forward(request,response);
                        case "employer":
                            request.getRequestDispatcher("employer.jsp").forward(request,response);

                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        } else {
            // Đăng nhập không hợp lệ, chuyển hướng đến trang đăng nhập với thông báo lỗi
            response.sendRedirect("/Login.jsp");
        }
    }

    private boolean isValidLogin(String username, String password) {
        try {
            // Kết nối cơ sở dữ liệu
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Tạo truy vấn SQL
            String sql = "SELECT * FROM ecommerce WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Kiểm tra kết quả
            if (resultSet.next()) {
                return true;
            }

            // Đóng kết nối và các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}

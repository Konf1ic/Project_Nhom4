package com.example.web.service;

import com.example.web.model.Cart;
import com.example.web.model.Product;
import com.example.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserService {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/ecommerces";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "18092004";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static final String INSERT_ecommerce_SQL = "INSERT INTO ecommerces (username, password, email, position) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from ecommerces";
    private static final String ADMIN_ADD_STAFF_SQL = "INSERT INTO ecommerces (username,password,email,name,age,phone_number,address,wage,position) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO Product (name, price, describes, image, type, quantity) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String INSERT_To_List = "INSERT INTO Cart (id,name, price, describes, image, type, quantity) VALUES (?,?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,name,price, describes,image,type,quantity from Product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String SELECT_CART = "select * from Cart";
    private static final String DELETE_PRODUCT_SQL = "delete from Product where id = ?;";
    private static final String DELETE_CART_SQL = "delete from Cart where id = ?;";

    @Override
    public void insertUser(User user) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ecommerce_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<User> selectAll() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String phone_number = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            double wage = resultSet.getDouble("wage");
            String position = resultSet.getString("position");
            list.add(new User(id, username, password, email, name, age, phone_number, address, wage, position));
        }
        return list;
    }

    @Override
    public User getUserByUsernameAndPassword(String userName, String password) {
        User userFromDb = null;
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ecommerces where username = ? and password = ?");

            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userFromDb = new User();

                userFromDb.setUsername(rs.getString("username"));
                userFromDb.setPassword(rs.getString("password"));
                userFromDb.setId(rs.getInt("id"));
                userFromDb.setEmail(rs.getString("email"));
                userFromDb.setName(rs.getString("name"));
                userFromDb.setAge(rs.getInt("age"));
                userFromDb.setPhone_number(rs.getString("phone_number"));
                userFromDb.setAddress(rs.getString("address"));
                userFromDb.setWage(rs.getDouble("wage"));
                userFromDb.setPosition(rs.getString("position"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userFromDb;
    }

    @Override
    public void addStaffWithAdmin(User user) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ADMIN_ADD_STAFF_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getPhone_number());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setDouble(8, user.getWage());
            preparedStatement.setString(9, user.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> searchAccount(String name) throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        String query = "select * from ecommerces where username like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "%" + name + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            String phone_number = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            double wage = resultSet.getDouble("wage");
            String position = resultSet.getString("position");
            list.add(new User(id, username, password, email, age, phone_number, address, wage, position));
        }
        return list;
    }

    @Override
    public List<Cart> SelectCart() throws SQLException {
        List<Cart> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_CART);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String describes = resultSet.getString("describes");
            String image = resultSet.getString("image");
            String type = resultSet.getString("type");
            int quantity = resultSet.getInt("quantity");
            list.add(new Cart(id, name, price, describes, image, type, quantity));

        }
        return list;
    }

    @Override
    public void insertToList(Product product) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_To_List);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, product.getDescribes());
        preparedStatement.setString(5, product.getImage());
        preparedStatement.setString(6, product.getType());
        preparedStatement.setInt(7, product.getQuantity());
        preparedStatement.executeUpdate();


    }

    @Override
    public void Them(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescribes());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.setString(5, product.getType());
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String description = resultSet.getString("description");
            String image = resultSet.getString("image");
            String type = resultSet.getString("type");
            int quantity = resultSet.getInt("quantity");
            product = new Product(id, name, price, description, image, type, quantity);

        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {

        List<Product> list = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCT);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String describesd = resultSet.getString("describes");
            String image = resultSet.getString("image");
            String type = resultSet.getString("type");
            int quantity = resultSet.getInt("quantity");
            list.add(new Product(id, name, price, describesd, image, type, quantity));
        }
        return list;

    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {

        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean deleteCart(int id) {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CART_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
}
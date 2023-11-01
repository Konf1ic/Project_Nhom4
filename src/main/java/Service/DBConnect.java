package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private String hostName = "localhost:3306";
    private String dbName = "ecommerces";
    private String username = "root";
    private String password = "vanh250204";

    private String connectionURL = "jdbc:mysql://"+hostName+"/"+dbName;
    public Connection connection() {
        return null;
    }

    public Connection getConnection(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


}
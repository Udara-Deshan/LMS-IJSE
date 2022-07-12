package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS_IJSE", "root", "1234");
    }


    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        return (null==dBConnection)?
                (dBConnection= new DBConnection()):
                (dBConnection);
    }

    public Connection getConnection(){
        return connection;
    }
}

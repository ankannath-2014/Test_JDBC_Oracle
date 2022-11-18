package JdbcConfig;

import java.sql.*;

// Database Configuration Class
public class DataBaseConfig {
    Connection con;



    public Connection Config(){
        try {
            // Stating the class name or type of database here Oracle
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Establishing the connectivity
        try {
            // Driver manager for database information such as url, username and password
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //returning the connection object
        return con;
    }
}


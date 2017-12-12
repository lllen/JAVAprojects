package databaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
    private final String HOST="jdbc:mysql://localhost:3306/enterprise";
    private final String USERNAME="len";
    private final String PASSWORD="sq123";

    private Connection connection;

    public DBconnector(){
        try{
            connection= DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}

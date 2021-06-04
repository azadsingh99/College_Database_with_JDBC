package org.Collge.connection;

import java.sql.*;

public class JDBCconnect {
    static Connection connection = null;
    static Statement statement = null;

    public JDBCconnect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "Qwer@#123");
        statement = connection.createStatement();
    }

    public static int executeUpdate(String query) throws SQLException{
        int result = statement.executeUpdate(query);
        return result;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }
}

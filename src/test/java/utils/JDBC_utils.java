package utils;

import java.sql.*;

public class JDBC_utils {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    private static Statement ConnectToSQL() {
        try {
            connection = DriverManager.getConnection(ConfigReader.readProperty("connection_url"),
                    ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            throw new RuntimeException("Could not connect to DB", ex);
        }
        return statement;
    }

    public static ResultSet queryDB(String query) {
        statement = ConnectToSQL();
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to execute query",ex);
        } finally {
            closeConnection();
        }
    }

    private static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


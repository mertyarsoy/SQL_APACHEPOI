package jdbc;

import org.junit.Test;
import utils.ConfigReader;
import utils.JDBC_utils;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class JDBC_Intro {

    @Test
    public void connectionTest() throws SQLException {
        ResultSet result = JDBC_utils.queryDB("SELECT * FROM employees");

        result.next();
        System.out.println(result.getString(1));
        System.out.println(result.getString(2));

        result.next();
        System.out.println(result.getString(1));

        while (result.next()) {
            System.out.println(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3) + " " +
                    result.getString(4));
        }

    }

    @Test
    public void queryTest() throws SQLException {
        ResultSet result = JDBC_utils.queryDB("SELECT * FROM employees");

        ResultSetMetaData metaData = result.getMetaData();

        while (result.next()) { // iterating over rows in a table

            for (int i = 1; i <= metaData.getColumnCount(); i++) { // iterating over columns in a table
                if (i==1) System.out.print("|");
                System.out.print(result.getString(i)+" |");
            }
            System.out.println(); // it will print a new line for new row
        }
    }
}

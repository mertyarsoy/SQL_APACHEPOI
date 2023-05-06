package jdbc;

import org.junit.Assert;
import org.junit.Test;
import utils.ConfigReader;
import utils.JDBC_utils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class JDBC_Adv {
    @Test
    public void test1() throws SQLException {
        ResultSet result = JDBC_utils.queryDB("SELECT * FROM employees");
        ResultSetMetaData resultSetMetaData = result.getMetaData();

        List<Map<String, Object>> resultData = new ArrayList<>();

        while (result.next()) { // every next row
            Map<String, Object> rowMap = new HashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) { // every next column
                rowMap.put(resultSetMetaData.getColumnName(i), result.getObject(i));
            }
            resultData.add(rowMap);

            for (int i = 0; i < resultData.size(); i++) {
                if (resultData.get(i).get("FIRST_NAME").equals("TJ")) {
                    int salary = Integer.parseInt(resultData.get(i).get("SALARY").toString());
                    Assert.assertEquals(23000, salary);
                }
            }
        }
    }
    public void test2(){
        ResultSet resultSet = JDBC_utils.queryDB("SELECT * FROM employees");

    }
}

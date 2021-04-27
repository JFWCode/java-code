package com.demo.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {
    @Test
    public void demo1() throws Exception {
//      register manually
//      Class.forName("com.ysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3307/xxl-job?Unicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        // connect to database
        Connection conn = DriverManager.getConnection(url, "xxl", "xxlpassword");
        // 获得语句执行者
        Statement statement = conn.createStatement();

        String sql = "SELECT t.*\n" +
                "         FROM `xxl-job`.XXL_JOB_QRTZ_TRIGGER_INFO t\n" +
                "         LIMIT 501";
        ResultSet show_tables = statement.executeQuery(sql);

        while(show_tables.next()) {
            // get column data by column name
            String s = show_tables.getString("test_run_id");
            System.out.println(s);
        }

        show_tables.close();
        statement.close();
        conn.close();
    }
}

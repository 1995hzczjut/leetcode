package com.leetcode.array;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zhancong Huang
 * @date 13:05 2019/2/20
 */
public class service {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = DriverManager.getConnection(url,"root","");
        System.out.println(conn);
    }
}

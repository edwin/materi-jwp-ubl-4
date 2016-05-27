package com.ubl.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <pre>
 * contoh helper class untuk buka koneksi ke db
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com >
 * May 27, 2016 11:09:53 AM
 *
 */
public class DatabaseService {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";

        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + dbName, userName, password);

        return conn;
    }

    public static void closeConnection(Connection conn) throws Exception {
        conn.close();
    }

}

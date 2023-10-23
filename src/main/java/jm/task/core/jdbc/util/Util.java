package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";

    public Connection getConnection() {
        Connection connection = null;

        //System.out.println("Registering JDBC driver...");
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            System.out.println("Соединение установлено");
        } catch (SQLException th) {
            System.out.println("Ошибка соединения!");
            th.printStackTrace();
        }

        return connection;
    }
}
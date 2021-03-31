package com.green.cinemamanagement.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/cinemamanagement?user=root&password=123456";

    public DBManager(){

    }

    public Connection getDBConnection(){
        Connection connection = null;

        try {
            Class.forName(DB_Driver);
            connection = DriverManager.getConnection(DB_CONNECTION);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("get db connection success");

        return  connection;
    }
}

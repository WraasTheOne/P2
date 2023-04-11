package com.example.app;


import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DBUtil {

    public static void start() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        Connection myDbConn = null;
        String url = dotenv.get("DATABASE_MYSQL_AZURE");
        String User = dotenv.get("USER_MYSQL_AZURE");
        String Pasword = dotenv.get("PASSWORD_MYSQL_AZURE");
        Statement statement = null;

        try {
            myDbConn = DriverManager.getConnection(url, User, Pasword);
            statement = myDbConn.createStatement();
        } catch (SQLException ex) {
            System.out.println("prut " + ex);
        }

        String test = "select * from users";


        System.out.println(statement);
        ResultSet resultSet = statement.executeQuery("select * from kooperation");
        System.out.println(resultSet);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

    }
}

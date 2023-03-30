package com.example.app;



import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Objects;

public class DBUtil {

    public static void start() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        Connection myDbConn = null;
        String url = dotenv.get("DATABASE_MYSQL_AZURE");
        String User = dotenv.get("USER_MYSQL_AZURE");
        String Pasword = dotenv.get("PASSWORD_MYSQL_AZURE");

        try {
            myDbConn = DriverManager.getConnection(url, User, Pasword);
        }catch (SQLException ex){
            System.out.println("prut "+ ex);
        }



    }
}

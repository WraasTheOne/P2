package com.example.app;


import java.sql.*;

public class DBUtil {

    public DBUtil(){
        Connection myDbConn = null;
        String url="jdbc:mysql://wmsp2.mysql.database.azure.com:3306/firtMazur?useSSL=true";
        try {
            myDbConn = DriverManager.getConnection(url, "ADM", "QQ1122ww");
        }catch (SQLException ex){
            System.out.println("prut "+ ex);
        }

    }
}

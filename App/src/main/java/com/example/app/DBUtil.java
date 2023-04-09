package com.example.app;

import javax.xml.transform.Result;
import java.sql.*;

public class DBUtil
{
    private String username;
    private String DBName;
    private String password = "QQ1122ww";
    private String user = "ADM";
    private String url = "jdbc:mysql://wmsp2.mysql.database.azure.com:3306/firtMazur?useSSL=true";
    //private String sql = "SELECT Name, Password FROM p2.kooperation";

    private static final DBUtil instance = new DBUtil();

    private DBUtil() {}

    public static DBUtil getInstance()
    {
        return instance;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


    public void connectToDB()
    {

    }

    public ResultSet sendStatement(String statement)
    {
        try
        {
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStatement = myConn.createStatement();
            return myStatement.executeQuery(statement);
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
            return null;
        }
    }

    public void disconnectFromDB()
    {

    }

    public void addToDB()
    {

    }

    public void removeFromDB()
    {

    }

    public void getFromDB()
    {

    }
}

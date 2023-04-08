package com.example.app;

import javax.xml.transform.Result;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;


public class DBUtil
{
    private String DBName;

    private Dotenv dotenv = Dotenv.load();
    private String password = dotenv.get("PASSWORD_MYSQL_AZURE");
    private String user = dotenv.get("USER_MYSQL_AZURE");
    private String url = dotenv.get("DATABASE_MYSQL_AZURE");
    //private String sql = "SELECT Name, Password FROM p2.kooperation";



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

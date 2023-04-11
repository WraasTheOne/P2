package com.example.app;

import javax.xml.transform.Result;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class DBUtil
{
    private String username;
    private String DBName;

    private Dotenv dotenv = Dotenv.load();
    private String url = dotenv.get("DATABASE_MYSQL_AZURE");
    private String user = dotenv.get("USER_MYSQL_AZURE");
    private String password = dotenv.get("PASSWORD_MYSQL_AZURE");
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


    public Connection connectToDB() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
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
            System.out.println("Something went wrong");
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

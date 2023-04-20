package com.example.app.TableStructure;



import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DBUtil {

    private static Dotenv dotenv = Dotenv.load();
    private static String url = dotenv.get("DATABASE_MYSQL_AZURE");
    private static String User = dotenv.get("USER_MYSQL_AZURE");
    private static String Pasword = dotenv.get("PASSWORD_MYSQL_AZURE");

    public static void start() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        Connection myDbConn = null;

        Statement statement = null;

        try {
            myDbConn = DriverManager.getConnection(url, User, Pasword);
            statement = myDbConn.createStatement();
        } catch (SQLException ex) {
            System.out.println("prut " + ex);
        }

        String test = "select * from kooperation";


        System.out.println(statement);
        ResultSet resultSet = statement.executeQuery(test);
        System.out.println(resultSet);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name"));
        }

    }
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, User, Pasword);
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database!");
            e.printStackTrace();
        }

        return conn;
    }
    public static void setColumnValueInt(String tableName, String columName, int value, String id, int obId) {

        String sql = "UPDATE " + tableName + " SET " + columName + " = ? WHERE " + id + " = ?";
        try (
                PreparedStatement pstmt = getConnection().prepareStatement(sql)
        ) {
            pstmt.setInt(1, value);
            pstmt.setInt(2, obId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void setColumnValueStr(String tableName, String columName, String value, String id, int obId) {

        String sql = "UPDATE " + tableName + " SET " + columName + " = ? WHERE " + id + " = ?";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, value);
            pstmt.setInt(2, obId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet findUsername(String username, String table) throws SQLException
    {
        String sql = "SELECT Name, password FROM " + table + " WHERE name = '" + username + "'";

        System.out.println("SELECT Name, password FROM " + table + " WHERE name = '" + username + "'");

        Statement myStatement = getConnection().createStatement();
        return myStatement.executeQuery(sql);
    }



    public static void insertBigbag(int Ownerid, int NUVProcess, String type, int Location, String BrugerSenop) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String opdateTime = date.format(formatter);

        String sql = "INSERT INTO bigbags (Ownerid,NUVProcess,TidSenOp,Type,Location,BrugerSenop) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, Ownerid);
            pstmt.setInt(2, NUVProcess);
            pstmt.setString(3, opdateTime);
            pstmt.setString(4,type);
            pstmt.setInt(5,Location);
            pstmt.setString(6,BrugerSenop);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }




}


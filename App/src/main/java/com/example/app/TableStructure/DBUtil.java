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

    public static Boolean findUser(String username, String password, String table)
    {
        String sql = "SELECT * FROM " + table + " WHERE Name = ? AND Password = ?";
        try(PreparedStatement pstmt = getConnection().prepareStatement(sql)){
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                com.example.app.TableStructure.User.setID(resultSet.getInt(HashTable.getUserTypeHashValue(table)));
                com.example.app.TableStructure.User.setName(resultSet.getString("Name"));
                com.example.app.TableStructure.User.setPassword(resultSet.getString("Password"));
                return true;
            }
            else {
                return false;
            }

        }catch (SQLException e){
            System.out.println(e);
            return null;
        }

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

    public static String insertUser(String newUsername, String newPassword, String userType)
    {
        try
        {
            String sqlInsertUser = "INSERT INTO " + userType + " (name, Password) VALUES (?, ?)";

            //Check if the user exists, if not, we continue creating the user
            if(DBUtil.findUser(newUsername, newPassword, userType))
            {
                System.out.println("User already exists");
                return "User already exists";
            }
            else
            {
                //User creation
                PreparedStatement pstmt = getConnection().prepareStatement(sqlInsertUser);
                pstmt.setString(1, newUsername);
                pstmt.setString(2, newPassword);
                pstmt.executeUpdate();
                return "User created!";
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return "Something went wrong";
        }

    }
    public static String removeUser(String username, String userType)
    {
        try
        {
            String sqlFindUser = "SELECT * FROM " + userType + " WHERE Name = ?";
            String sqlFindRelatedBigBags = "SELECT * FROM bigbags WHERE ownerId = ?";

            //We find the user to then extract the ID
            PreparedStatement pstmt = getConnection().prepareStatement(sqlFindUser);
            pstmt.setString(1, username);

            ResultSet set = pstmt.executeQuery();
            set.next();
            int idOfUser = set.getInt("KID");

            //We find the big bags related to the user and default all of them
            pstmt = getConnection().prepareStatement(sqlFindRelatedBigBags);
            pstmt.setInt(1, idOfUser);
            set = pstmt.executeQuery();

            while(set.next())
            {
                System.out.println(set.getInt("BID"));
                DBUtil.setColumnValueInt("bigbags","ownerId", 0, "BID", set.getInt("BID"));
            }
            System.out.println("OwnerID defaulted");

            //We remove the user
            String typeOfUserID = null;

            switch(userType)
            {
                case "kooperation":
                    typeOfUserID = "KID";
                    break;
                case "centercoop":
                    typeOfUserID = "CID";
                    break;
                case "admin":
                    typeOfUserID = "AID";
                    break;
            }

            String sqlRemoveUser = "DELETE FROM " + userType + " WHERE (" + typeOfUserID + " = ?)";
            pstmt = getConnection().prepareStatement(sqlRemoveUser);
            pstmt.setInt(1, idOfUser);
            pstmt.executeUpdate();

            return "User removed";
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return "Something went wrong";
        }

    }

}


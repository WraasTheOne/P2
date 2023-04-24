package com.example.app.TableStructure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.app.TableStructure.DBUtil.getConnection;

public class Admin extends User {

    public Admin(int AID, String name, String password) {
        ID = AID;
        Name = name;
        Password = password;
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
            String typeOfUserID = null;

            //We find the user to then extract the ID
            PreparedStatement pstmt = getConnection().prepareStatement(sqlFindUser);
            pstmt.setString(1, username);

            ResultSet set = pstmt.executeQuery();
            set.next();

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

            int idOfUser = set.getInt(typeOfUserID);

            //We find the big bags related to the user and default all of them
            pstmt = getConnection().prepareStatement(sqlFindRelatedBigBags);
            pstmt.setInt(1, idOfUser);
            set = pstmt.executeQuery();

            while(set.next())
            {
                System.out.println(set.getInt("BID"));
                DBUtil.setColumnValueInt("bigbags","ownerId", 0, "BID", set.getInt("BID"));
                DBUtil.setColumnValueStr("bigbags", "BrugerSenop", "Admin", "BID", set.getInt("BID"));
            }
            System.out.println("OwnerID defaulted");

            //We remove the user
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
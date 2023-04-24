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

    public static void updateTimeForBigbag(int BID){

        String sql = "UPDATE Bigbags set tidsenop = current_timestamp() where BID = ?";

        try(PreparedStatement pstmt = getConnection().prepareStatement(sql)){
            pstmt.setInt(1,BID);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }


    }



    public static void setColumnValueInt(String tableName, String columName, int value, String id, int obId) {

        String sql = "UPDATE " + tableName + " SET " + columName + " = ? WHERE " + id + " = ?";

        System.out.println("UPDATE " + tableName + " SET " + columName + " = ? WHERE " + id + " = ? " + value +  " " + obId);
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

    public static int getsingleValue(String tableName, int BigBagID){
        String sql = "SELECT NUVProcess from bigbags where BID = "+BigBagID;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet resultat = statement.executeQuery();

            resultat.next();
            System.out.println("Nuvprocess fra "+BigBagID+" er lig med "+resultat.getInt(1));
            return resultat.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyColumnValue(String tableName, int NUVProcess,int BigBagID){
        String sql = "UPDATE  " + tableName + " SET TidligProcess = " + NUVProcess+" where BID = " + BigBagID;
        try(PreparedStatement statement = getConnection().prepareStatement(sql)) {

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
                System.out.println(com.example.app.TableStructure.User.getID());
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

        String sql = "INSERT INTO bigbags (OwnerId,NUVProcess,TidSenOp,Type,Location,BrugerSenop) VALUES (?,?,current_timestamp(),?,?,?)";

            try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, Ownerid);
            pstmt.setInt(2, NUVProcess);
            pstmt.setString(3,type);
            pstmt.setInt(4,Location);
            pstmt.setString(5,BrugerSenop);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insertWalleCube(String Type, int CenterId){

        String sql = "Insert into Wallecubes (Type, CenterId)  Values (?,?)";
        try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1,Type);
            pstmt.setInt(2,CenterId);
            pstmt.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static int getIntCoulmnHighestData(String tablename, String column){
        int returnvalue = 0;
        String sql = "Select " + column + " from " + tablename;

        try(PreparedStatement pstmt = getConnection().prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                returnvalue = rs.getInt(column);
            }
            System.out.println(returnvalue);
            return returnvalue;
        }catch (SQLException e){
            System.out.println(e);
            return 0;
        }


    }



    /*
     *  Ved godt at den ikke skal ligge her -k
     *
     */

    public static void allProcesses(int OwnerID, int processID){

        String sql = "select * from bigbags where OwnerId = "+OwnerID;
        // alternativt "select NUVProcess, BID from bigbags where OwnerID = "+OwnerID;
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}




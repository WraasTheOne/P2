package com.example.app.TableStructure;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

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
        String sql = "UPDATE  " + tableName + " SET TidligProcess = " + NUVProcess + " where BID = " + BigBagID;
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
                com.example.app.TableStructure.User.setUsertype(table);
                //Privat variabel for type user?
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

    public static String insertBigbag(int Ownerid, int NUVProcess, String type, int Location, String BrugerSenop) {


        String sql = "INSERT INTO bigbags (OwnerId,NUVProcess,TidSenOp,Type,Location,BrugerSenop) VALUES (?,?,current_timestamp(),?,?,?)";

            try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, Ownerid);
            pstmt.setInt(2, NUVProcess);
            pstmt.setString(3,type);
            pstmt.setInt(4,Location);
            pstmt.setString(5,BrugerSenop);
            pstmt.executeUpdate();
            return "Big Bag created";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Something went wrong";
        }

    }

    public static String removeBigBag(int BID)
    {

        try
        {//We remove the user
            String sqlRemoveBigBag = "DELETE FROM bigbags WHERE BID = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlRemoveBigBag);
            pstmt.setInt(1, BID);
            pstmt.executeUpdate();

            return "Big Bag removed";
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return "Something went wrong";
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

    public static ObservableList<TableData> getDataForTable(String company) throws SQLException
    {
        String sqlAccounts = "SELECT * FROM " + company;
        PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sqlAccounts);
        ResultSet set = pstmt.executeQuery();
        ObservableList<TableData> data = FXCollections.observableArrayList();
        String idType = null;

        switch (company)
        {
            case "kooperation":
                idType = "KID";
                break;
            case "centercoop":
                idType = "CID";
                break;
            case "admin":
                idType = "AID";
                break;
        }

        while(set.next())
        {
            data.add(new TableData(set.getInt(idType), set.getString("Name"), set.getString("Password")));
        }

        return data;
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

    public static ObservableList<BigBag> getDataForTable(String Table, int id, String column) throws SQLException
    {
        String sqlAccounts = "SELECT * FROM " + Table + " Where " + column + " = ?";
        PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sqlAccounts);
        pstmt.setInt(1,id);
        ResultSet set = pstmt.executeQuery();
        ObservableList<BigBag> data = FXCollections.observableArrayList();

        while(set.next())
        {
            data.add(new BigBag(set.getInt("BID"), set.getInt("OwnerId"), set.getInt("Nuvprocess"),set.getInt("Tidligprocess"),set.getString("Tidsenop"),set.getString("type"),set.getInt("Location"),set.getString("brugersenop"),set.getInt("Walleid")));
        }

        return data;
    }

    public static ObservableList<BigBag> getAllBigBags() throws SQLException
    {
        String sqlGetBigBags = "SELECT * FROM bigbags";
        PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sqlGetBigBags);
        ResultSet set = pstmt.executeQuery();
        ObservableList<BigBag> data = FXCollections.observableArrayList();

        while(set.next())
        {
            data.add(new BigBag(set.getInt("BID"), set.getInt("OwnerId"),
                    set.getInt("Nuvprocess"),set.getInt("Tidligprocess"),
                    set.getString("Tidsenop"),set.getString("type"),
                    set.getInt("Location"),set.getString("brugersenop"),
                    set.getInt("Walleid")));
        }

        return data;

    }

    public static ObservableList<WalleCube> getAllWalleCubes() throws SQLException
    {
        //Thinking of perhaps making a "getAllData" method instead of having
        //all big bags and wallecubes be found separately

        String sqlGetWalleCubes = "SELECT * FROM wallecubes";
        PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sqlGetWalleCubes);
        ResultSet set = pstmt.executeQuery();
        ObservableList<WalleCube> data = FXCollections.observableArrayList();

        while(set.next())
        {
            data.add(new WalleCube(set.getInt("WID"),
                                   set.getString("type"),
                                   set.getInt("CenterId")));
        }

        return data;

    }

    public static String addUser(String newUsername, String newPassword, String userType){

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

    public static String removeUser(String username, String userType){

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


    public static ObservableList<WalleCube> getDataForTableWalle(String Table, int id) throws SQLException
    {
        String sqlAccounts = "SELECT * FROM " + Table + " Where centerid = ?";
        PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sqlAccounts);
        pstmt.setInt(1,id);
        ResultSet set = pstmt.executeQuery();
        ObservableList<WalleCube> data = FXCollections.observableArrayList();


        while(set.next())
        {
            data.add(new WalleCube(set.getInt("WID"),set.getString("Type"),set.getInt("CenterId")));
        }

        return data;
    }


    public static void incrementColumnInt(String table, String columnName, String primaryKey, int id ){

        String sql = "UPDATE " + table + " SET " + columnName + " = " + columnName+" + 1" + " WHERE " + primaryKey+ "="+id;

        try {
            PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decrementColumnInt(String table, String columnName, String primaryKey, int id ,int amount){

        String sql = "UPDATE " + table + " SET " + columnName + " = " + columnName+" - amount" + " WHERE " + primaryKey+ "="+id;

        try {
            PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


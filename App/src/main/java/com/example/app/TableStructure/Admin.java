package com.example.app.TableStructure;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends User implements bigbagInterface, WalleCubeInterface{

    public Admin(int AID, String name, String password) {
        ID = AID;
        Name = name;
        Password = password;
    }

    @Override
    public String createBigbag(int userID,String proces, String location, String type) {
        int processId = HashTable.getProcessHashValue(proces);
        int locationId = HashTable.getLocationHashValue(location);

        return DBUtil.insertBigbag(userID, processId, type, locationId, User.getName());
    }

    public static String removeBigBag(int BID)
    {
        return DBUtil.removeBigBag(BID);
    }

    @Override
    public void changeProcess(String procesChangeTo, BigBag bigBag) {
        int tidProcess = DBUtil.getsingleValue("bigbags",1);
        int newProcess = HashTable.getProcessHashValue(procesChangeTo);
        DBUtil.copyColumnValue("bigbags",tidProcess,1);
        DBUtil.updateTimeForBigbag(1);
        //BigBag.setBID(1);
        //System.out.println(BigBag.getBID());
        //BigBag.setNUVProcess(newProcess);
    }

    @Override
    public void changeLocation(String locationChangeTo, BigBag bigBag){
        int newLocation = HashTable.getLocationHashValue(locationChangeTo);
        DBUtil.setColumnValueInt("Bigbags","Location",newLocation,"BID",bigBag.getBID());
        DBUtil.updateTimeForBigbag(bigBag.getBID());
    }

    @Override
    public void changeMaterial(String materialChangeTo, BigBag bigBag){
        String newMaterial = materialChangeTo;
        DBUtil.setColumnValueStr("Bigbags","Type",newMaterial,"BID",bigBag.getBID());
        DBUtil.updateTimeForBigbag(bigBag.getBID());
    }

    public static String insertUser(String newUsername, String newPassword, String userType)
    {

        String Status = DBUtil.addUser(newUsername,newPassword,userType);

        return Status;

    }

    public static String removeUser(String username, String userType)
    {
       String status = DBUtil.removeUser(username,userType);
       return status;

    }

    @Override
    public String createWalleCube()
    {
        return "";
    }
    @Override
    public String removeWalleCube()
    {
        return "";
    }

    @Override
    public String changeCubeMaterial()
    {
        return "";
    }

}
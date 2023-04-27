package com.example.app.TableStructure;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends User implements bigbagInterface{



    @Override
    public void createBigbag(String proces, String location, String type) {
        int processId = HashTable.getProcessHashValue(proces);
        int locationId = HashTable.getLocationHashValue(location);

        DBUtil.insertBigbag(User.getID(),processId,type,locationId,User.getName());
    }

    @Override
    public void changeProcess(String procesChangeTo, BigBag bigBag) {
        int tidProcess = DBUtil.getsingleValue("bigbags", 1);
        int newProcess = HashTable.getProcessHashValue(procesChangeTo);
        DBUtil.copyColumnValue("bigbags", tidProcess, 1);
        DBUtil.updateTimeForBigbag(1);
        //BigBag.setBID(1);
        //System.out.println(BigBag.getBID());
        //BigBag.setNUVProcess(newProcess);
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



}
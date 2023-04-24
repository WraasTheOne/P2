package com.example.app.TableStructure;

public class Kooperation extends User implements bigbagInterface{

    @Override
    public static void createBigbag(String proces, String location, String type){
        int processId = HashTable.getProcessHashValue(proces);
        int locationId = HashTable.getLocationHashValue(location);

        DBUtil.insertBigbag(User.getID(),processId,type,locationId,User.getName());
    }

}

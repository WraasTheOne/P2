package com.example.app.TableStructure;
public class Admin extends User implements bigbagInterface{

    public Admin(int AID, String name, String password) {
        ID = AID;
        Name = name;
        Password = password;
    }

    @Override
    public void createBigbag(String proces, String location, String type) {
        int processId = HashTable.getProcessHashValue(proces);
        int locationId = HashTable.getLocationHashValue(location);

        DBUtil.insertBigbag(User.getID(),processId,type,locationId,User.getName());
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

}
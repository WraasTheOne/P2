package com.example.app.TableStructure;


public class Kooperation extends User implements bigbagInterface{

    @Override
    public void createBigbag(String proces, String location, String type) {
        int processId = HashTable.getProcessHashValue(proces);
        int locationId = HashTable.getLocationHashValue(location);

        DBUtil.insertBigbag(User.getID(), processId, type, locationId, User.getName());
    }




    @Override
    public void changeProcess(String procesChangeTo, BigBag bigbag) {
        int tidProcess = DBUtil.getsingleValue("bigbags",bigbag.getBID());
        int newProcess = HashTable.getProcessHashValue(procesChangeTo);
        DBUtil.copyColumnValue("bigbags",tidProcess,bigbag.getBID());
        DBUtil.setColumnValueInt("Bigbags","NuvProcess",newProcess,"BID",bigbag.getBID());
        DBUtil.setColumnValueStr("Bigbags","brugersenop",User.getName(),"BID",bigbag.getBID());
        DBUtil.incrementColumnInt("proces","AntalIPro","PID",newProcess);
        DBUtil.decrementColumnInt("proces","AntalIPro","PID",tidProcess,1);
        DBUtil.updateTimeForBigbag(bigbag.getBID());
    }

    @Override
    public void changeLocation(String locationChangeTo, BigBag bigBag){
        int tidligereLokation = bigBag.getLocation();
        int newLocation = HashTable.getLocationHashValue(locationChangeTo);
        DBUtil.setColumnValueInt("Bigbags","Location",newLocation,"BID",bigBag.getBID());
        DBUtil.updateTimeForBigbag(bigBag.getBID());
        DBUtil.decrementColumnInt("location","AntalILoca","LID",tidligereLokation,1);
        DBUtil.incrementColumnInt("location","AntalILoca","LID",newLocation);
    }

    @Override
    public void changeMaterial(String materialChangeTo, BigBag bigBag){
        String newMaterial = materialChangeTo;
        DBUtil.setColumnValueStr("Bigbags","Type",newMaterial,"BID",bigBag.getBID());
        DBUtil.updateTimeForBigbag(bigBag.getBID());
    }

}

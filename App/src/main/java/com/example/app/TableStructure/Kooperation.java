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
        DBUtil.updateTimeForBigbag(bigbag.getBID());
    }

}

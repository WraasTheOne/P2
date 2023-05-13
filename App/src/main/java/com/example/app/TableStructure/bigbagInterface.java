package com.example.app.TableStructure;

public interface bigbagInterface {

    String createBigbag(int userID, String proces, String location, String type);

    void changeProcess(String procesChangeTo, BigBag bigbag);

    void changeLocation(String locationChangeTo,BigBag bigbag);


    void changeMaterial(String materialChangeTo, BigBag bigBag);

}

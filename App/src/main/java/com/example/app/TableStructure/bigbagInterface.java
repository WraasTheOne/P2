package com.example.app.TableStructure;

public interface bigbagInterface {

    void createBigbag(String proces, String location, String type);

    void changeProcess(String procesChangeTo, BigBag bigbag);

    void changeLocation(String locationChangeTo,BigBag bigbag);


    void changeMaterial(String materialChangeTo, BigBag bigBag);

}

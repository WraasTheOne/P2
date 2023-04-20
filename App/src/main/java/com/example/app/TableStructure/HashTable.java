package com.example.app.TableStructure;

import java.util.HashMap;

public class HashTable {

    private static final HashMap<String, Integer> processes = new HashMap<>();

    private static final HashMap<String, Integer> locations = new HashMap<>();

    private static final HashMap<String, String> userType = new HashMap<>();


    private static final String[] procesNames  = {"Collection", "Stacking","Sorting","Label","Storage CORPS","Centercorp Delivery","Compress and weighing","Label compressed weight","Storage centerCORP","Selling"};

    private static final int[] procesIndex = {1,2,3,4,5,6,7,8,9,10};

    private static final String[] locationNames  = {"Location 1", "Location 2","Location 3"};

    private static final int[] locationIndex = {1,2,3};

    private static final String[] userTypeLong  = {"kooperation", "admin","centercoop"};

    private static final String[] userTypeShort  = {"KID", "AID","CID"};



    public static void makeHashTables(){
        for (int i : procesIndex){
            processes.put(procesNames[i-1],procesIndex[i-1]);
        }
        for (int i : locationIndex){
            locations.put(locationNames[i-1],locationIndex[i-1]);
        }
        for(int i = 0; i < userTypeLong.length; i++){
            userType.put(userTypeLong[i],userTypeShort[i]);
        }

    }

    public static int getLocationHashValue(String location){
        return locations.get(location);
    }

    public static int getProcessHashValue(String process){

        return processes.get(process);

    }

    public static String getUserTypeHashValue(String UserType){

        return userType.get(UserType);

    }

}

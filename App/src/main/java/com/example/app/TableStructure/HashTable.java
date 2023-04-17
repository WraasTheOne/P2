package com.example.app.TableStructure;

import java.util.HashMap;

public class HashTable {

    private static final HashMap<String, Integer> processes = new HashMap<>();

    private static final HashMap<String, Integer> locations = new HashMap<>();

    private static final String[] procesNames  = {"proces 1", "proces 2"};

    private static final int[] procesIndex = {1,2};

    public static void makeHashTables(){
        for (int i : procesIndex){
            processes.put(procesNames[i-1],procesIndex[i-1]);
        }

        System.out.println(processes.get("proces 1"));
    }

}

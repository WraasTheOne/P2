package com.example.app.TableStructure;

public class CenterCoop extends User{

        public static void createBigbag(String type, String BIDS){
            String[] BIDSArray = BIDS.split(",");
            int[] BID = new int[BIDSArray.length];
            for (int i = 0; i < BIDSArray.length; i++) {
                BID[i] = Integer.parseInt(BIDSArray[i]);
                System.out.println(BID[i]);
            }
            DBUtil.insertWalleCube(type,ID);


        }


}

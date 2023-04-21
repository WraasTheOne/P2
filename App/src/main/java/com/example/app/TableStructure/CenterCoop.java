package com.example.app.TableStructure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CenterCoop extends User{

        public static void createBigbag(String type, String BIDS) {
            String[] BIDSArray = BIDS.split(",");
            int[] BID = new int[BIDSArray.length];
            for (int i = 0; i < BIDSArray.length; i++) {
                BID[i] = Integer.parseInt(BIDSArray[i]);
                System.out.println(BID[i]);
            }
            DBUtil.insertWalleCube(type,ID);
            int WID = DBUtil.getIntCoulmnHighestData("wallecubes","WID");

            for (int i = 0; i < BID.length; i++){
                DBUtil.setColumnValueInt("bigbags","walleid",WID,"BID",BID[i]);
                DBUtil.updateTimeForBigbag(BID[i]);
            }

        }


}

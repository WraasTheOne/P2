package com.example.app.TableStructure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CenterCoop extends User implements WalleCubeInterface{

    /*public static void createWallecube(String type, String BIDS) {

    }*/

    @Override
    public String createWalleCube(String type, String BIDS, int CID)
    {
        int numberOfBigbags = 0;

        String[] BIDSArray = BIDS.split(",");
        int[] BID = new int[BIDSArray.length];
        for (int i = 0; i < BIDSArray.length; i++) {
            BID[i] = Integer.parseInt(BIDSArray[i]);
            System.out.println(BID[i]);
            numberOfBigbags = i +1;
        }

        DBUtil.insertWalleCube(type,ID);
        int WID = DBUtil.getIntCoulmnHighestData("wallecubes","WID");

        for (int i = 0; i < BID.length; i++){
            DBUtil.setColumnValueInt("bigbags","walleid",WID,"BID",BID[i]);
            DBUtil.updateTimeForBigbag(BID[i]);
        }

        DBUtil.decrementColumnInt("proces","antalipro","pid",9,numberOfBigbags);
        DBUtil.decrementColumnInt("location","antaliloca","lid",9,numberOfBigbags);

        return "";
    }
    @Override
    public String removeWalleCube(int WID)
    {
        return DBUtil.removeWalleCube(WID);
    }

    @Override
    public String changeCubeMaterial()
    {
        return "";
    }


}

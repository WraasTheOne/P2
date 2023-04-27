package com.example.app.TableStructure;

public class WalleCube {

    private  int WID;

    private  String type;

    private  int centerid;


    public WalleCube(int WID, String type, int centercoopId){
        this.WID = WID;
        this.type = type;
        this.centerid = centercoopId;
    }

    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCenterid() {
        return centerid;
    }

    public void setCentercoopId(int centercoopId) {
        this.centerid = centercoopId;
    }



}

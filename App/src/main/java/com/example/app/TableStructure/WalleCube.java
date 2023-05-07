package com.example.app.TableStructure;

public class WalleCube {

    private  int WID;

    private  String type;

    private  int CenterId;


    public WalleCube(int WID, String type, int centerid){
        this.WID = WID;
        this.type = type;
        this.CenterId = centerid;
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

    public int getCenterId() {
        return CenterId;
    }

    public void setCenterId(int centercoopId) {
        this.CenterId = centercoopId;
    }



}

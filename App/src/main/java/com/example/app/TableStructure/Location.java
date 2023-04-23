package com.example.app.TableStructure;

public class Location {
    private int lid;
    private String locaName;
    private int antalILoca;

    public Location(int lid, String locaName, int antalILoca) {
        this.lid = lid;
        this.locaName = locaName;
        this.antalILoca = antalILoca;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLocaName() {
        return locaName;
    }

    public void setLocaName(String locaName) {
        this.locaName = locaName;
    }

    public int getAntalILoca() {
        return antalILoca;
    }

    public void setAntalILoca(int antalILoca) {
        this.antalILoca = antalILoca;
    }
}


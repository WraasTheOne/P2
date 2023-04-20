package com.example.app.TableStructure;
public class Admin {
    private int AID;
    private String name;
    private String password;

    public Admin(int AID, String name, String password) {
        this.AID = AID;
        this.name = name;
        this.password = password;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.example.app.TableStructure;

public class Kooperation {
    private int kid;
    private String name;
    private String password;
    private int bid;

    public Kooperation(int kid, String name, String password, int bid) {
        this.kid = kid;
        this.name = name;
        this.password = password;
        this.bid = bid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
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

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}

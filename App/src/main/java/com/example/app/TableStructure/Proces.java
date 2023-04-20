package com.example.app.TableStructure;

public class Proces {
    private int PID;
    private String ProName;
    private int AntalIPro;

    public Proces(int PID, String ProName, int AntalIPro) {
        this.PID = PID;
        this.ProName = ProName;
        this.AntalIPro = AntalIPro;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String ProName) {
        this.ProName = ProName;
    }

    public int getAntalIPro() {
        return AntalIPro;
    }

    public void setAntalIPro(int AntalIPro) {
        this.AntalIPro = AntalIPro;
    }

    public String getProces() {
        return "Proces{" +
                "PID=" + PID +
                ", ProName='" + ProName + '\'' +
                ", AntalIPro=" + AntalIPro +
                '}';
    }
}


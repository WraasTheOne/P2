package com.example.app.TableStructure;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class BigBags {

    private final String dbTable = "bigbags";
    private final String dbId = "BID";
    private int BID;
    private int OwnerId;
    private int NUVProcess;
    private String TidligProcess;
    private String TidSenOp;
    private String Type;
    private int Location;
    private String BrugerSenop;

    public BigBags(int BID, int OwnerId, int NUVProcess, String TidligProcess, String TidSenOp, String Type, int Location, String BrugerSenop) {
        this.BID = BID;
        this.OwnerId = OwnerId;
        this.NUVProcess = NUVProcess;
        this.TidligProcess = TidligProcess;
        this.TidSenOp = TidSenOp;
        this.Type = Type;
        this.Location = Location;
        this.BrugerSenop = BrugerSenop;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
        DBUtil.setColumnValueInt(dbTable, "BID", BID, "OwnerId", this.OwnerId);
        setTidSenOp();

    }

    public int getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(int OwnerId) {
        this.OwnerId = OwnerId;
        DBUtil.setColumnValueInt(dbTable, "OwnerId", OwnerId, dbId, this.BID);
        setTidSenOp();
    }

    public int getNUVProcess() {
        return NUVProcess;
    }

    public void setNUVProcess(int NUVProcess) {
        this.NUVProcess = NUVProcess;
        DBUtil.setColumnValueInt(dbTable, "NUVProcess", NUVProcess, dbId, this.BID);
        setTidSenOp();

    }

    public String getTidligProcess() {
        return TidligProcess;
    }

    public void setTidligProcess(String TidligProcess) {
        this.TidligProcess = TidligProcess;
        DBUtil.setColumnValueStr(dbTable, "TidligProcess", TidligProcess, dbId, this.BID);
        setTidSenOp();
    }

    public String getTidSenOp() {

        return TidSenOp;
    }

    public void setTidSenOp() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);

        this.TidSenOp = formattedDate;

        DBUtil.setColumnValueStr(dbTable, "TidSenOp", formattedDate, dbId, this.BID);
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
        DBUtil.setColumnValueStr(dbTable, "Type", Type, dbId, this.BID);
        setTidSenOp();
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int Location) {
        this.Location = Location;
        DBUtil.setColumnValueInt(dbTable, "Location", Location, dbId, this.BID);
        setTidSenOp();

    }

    public String getBrugerSenop() {
        return BrugerSenop;
    }

    public void setBrugerSenop(String BrugerSenop) {
        this.BrugerSenop = BrugerSenop;
        DBUtil.setColumnValueInt(dbTable, "NUVProcess", NUVProcess, dbId, this.BID);
        setTidSenOp();

    }

}


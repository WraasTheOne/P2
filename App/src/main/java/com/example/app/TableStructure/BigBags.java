package com.example.app.TableStructure;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class BigBags {

    private static final String dbTable = "bigbags";
    private static final String dbId = "BID";
    private static int BID;
    private static int OwnerId;
    private static int NUVProcess;
    private static String TidligProcess;
    private static String TidSenOp;
    private static String Type;
    private static int Location;
    private static String BrugerSenop;

   /* public static void BigBags(int BID, int OwnerId, int NUVProcess, String TidligProcess, String TidSenOp, String Type, int Location, String BrugerSenop) {
        BigBags.BID = BID;
        BigBags.OwnerId = OwnerId;
        BigBags.NUVProcess = NUVProcess;
        BigBags.TidligProcess = TidligProcess;
        BigBags.TidSenOp = TidSenOp;
        BigBags.Type = Type;
        BigBags.Location = Location;
        BigBags.BrugerSenop = BrugerSenop;
    }*/

    public static int getBID() {
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


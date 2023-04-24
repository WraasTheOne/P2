package com.example.app.TableStructure;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class BigBags {

    private static final String dbTable = "bigbags";
    private static final String dbId = "BID";
    private  int BID;
    private  int OwnerId;
    private  int NUVProcess;
    private  String TidligProcess;
    private  String TidSenOp;
    private  String Type;
    private  int Location;
    private  String BrugerSenop;

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
    public static void getBigbag(int currentId, BigBags bigBags) {

        String currntString = "null_vardi";

        try {
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM bigbags WHERE BID = ?";
            PreparedStatement statement =  DBUtil.getConnection().prepareStatement(query);
            statement.setInt(1, (int) currentId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                bigBags.OwnerId = result.getInt("OwnerId");
                bigBags.NUVProcess = result.getInt("NUVProcess");
                bigBags.BID = result.getInt("BID");
                bigBags.Type = result.getString("Type");

                currntString = "OwnerId: " + bigBags.OwnerId + ", NUVProcess: " + bigBags.NUVProcess + ", BID: " + bigBags.BID+ ", Type: " + bigBags.Type;
                System.out.println(currntString);
            }


        } catch (SQLException ex) {
        }
    }

}


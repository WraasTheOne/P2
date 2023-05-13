package com.example.app.TableStructure;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class BigBag{

    private static final String dbTable = "bigbags";
    private static final String dbId = "BID";
    public  int BID;
    public  int OwnerId;
    public  int NUVProcess;
    public  int TidligProcess;
    public  String TidSenOp;
    public  String Type;
    public  int Location;
    public  String BrugerSenop;

    private int WalleID;


    public BigBag(){

    }


    public BigBag(int BID) throws SQLException, SQLException {
        this.BID = BID;

        String query = "SELECT * FROM bigbags WHERE BID = ?";
        PreparedStatement statement =  DBUtil.getConnection().prepareStatement(query);
        statement.setInt(1, (int) this.BID);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            assert false;
            this.OwnerId = result.getInt("OwnerId");
            this.NUVProcess = result.getInt("NUVProcess");
            this.BID = result.getInt("BID");
            this.Type = result.getString("Type");
            this.Location = result.getInt("Location");

        }

    }

    public int getWalleID(){
        return WalleID;
    }


    public int getBID() {
        return BID;
    }

    public void setBID(int BID1) {
        BID = BID1;
    }

    public int getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(int OwnerId) {
        OwnerId = OwnerId;
        DBUtil.setColumnValueInt(dbTable, "OwnerId", OwnerId, dbId, BID);
        setTidSenOp();
    }

    public int getNUVProcess() {
        return NUVProcess;
    }

    public void setNUVProcess(int NUVProcess) {
        this.NUVProcess = NUVProcess;
        DBUtil.setColumnValueInt(dbTable, "NUVProcess", NUVProcess, dbId, BID);
        //setTidSenOp();

    }

    public int getTidligProcess() {
        return TidligProcess;
    }

    public void setTidligProcess(int TidligProcess) {
        this.TidligProcess = TidligProcess;
        DBUtil.setColumnValueInt(dbTable, "TidligProcess", TidligProcess, dbId, BID);
        setTidSenOp();
    }

    public String getTidSenOp() {

        return TidSenOp;
    }

    public void setTidSenOp() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);

        TidSenOp = formattedDate;

        DBUtil.setColumnValueStr(dbTable, "TidSenOp", formattedDate, dbId, BID);
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
        DBUtil.setColumnValueStr(dbTable, "Type", Type, dbId, BID);
        setTidSenOp();
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int Location) {
        this.Location = Location;
        DBUtil.setColumnValueInt(dbTable, "Location", Location, dbId, BID);
        setTidSenOp();

    }

    public String getBrugerSenop() {
        return BrugerSenop;
    }

    public void setBrugerSenop(String BrugerSenop) {
        this.BrugerSenop = BrugerSenop;
        DBUtil.setColumnValueInt(dbTable, "NUVProcess", NUVProcess, dbId, BID);
        setTidSenOp();

    }

}


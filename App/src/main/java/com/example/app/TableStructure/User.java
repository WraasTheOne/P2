package com.example.app.TableStructure;

public class User {

    protected static int ID;

    protected static String Name;

    protected static String Password;
    private static String Usertype;

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        User.ID = ID;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static String getUsertype() {
        return Usertype;
    }

    public static void setUsertype(String usertype) {
        Usertype = usertype;
    }



}

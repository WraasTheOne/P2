package com.example.app.TableStructure;
public class Admin extends User implements bigbagInterface{

    public Admin(int AID, String name, String password) {
        ID = AID;
        Name = name;
        Password = password;
    }

}
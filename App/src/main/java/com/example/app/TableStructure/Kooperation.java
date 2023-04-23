package com.example.app.TableStructure;

public class Kooperation extends User{
    int numOfInstances = 0;

    public Kooperation(int kid, String name, String password) {
        numOfInstances++;
        System.out.println(numOfInstances);
        this.ID = kid;
        this.Name = name;
        this.Password = password;
    }
}

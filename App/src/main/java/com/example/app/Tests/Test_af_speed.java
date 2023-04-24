package com.example.app.Tests;

import com.example.app.TableStructure.DBUtil;

import java.sql.Connection;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Timer;

public class Test_af_speed {

    public static void main(String[] args) {

        System.out.println("Indtast antal forbindelser der skal testes");

        Connection connect = DBUtil.getConnection();




        Timestamp tid = new Timestamp(System.currentTimeMillis());




        Timestamp tid2 = new Timestamp(System.currentTimeMillis());


        System.out.println("Forskel er: "+tid2.compareTo(tid));



    }
}

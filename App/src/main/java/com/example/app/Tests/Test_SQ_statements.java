package com.example.app.Tests;

import com.example.app.TableStructure.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_SQ_statements {


    public static void main(String[] args) {

        Connection connect = DBUtil.getConnection();
        Scanner scan = new Scanner(System.in);
       while(true){
           System.out.println("Menu \n1 - indtast SQL statement i hånden \n2 - Vis alle tables\n3 -  exit");

           int valg = scan.nextInt();
           switch (valg){
               case 1:
                    ownStatement(connect);

                   break;

               case 2:
                   showTables(connect);
                   break;

               case 3:

                int svar = DBUtil.getsingleValue("bigbags",2);
                   System.out.println("vores svar er "+svar);

               case 4:
                   System.exit(0);


           }

       }



    }




    public static void ownStatement(Connection connect){

        System.out.println("Indtast statement til databasen");
        Scanner scanner = new Scanner(System.in);
        String sql = scanner.nextLine();

        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            //statement.setString(1,"value1");
            ResultSet res = statement.executeQuery();


            int i = 1;
            try {
                while (res.next()) {
                    System.out.println(res.getString(i));
                    i++;
                }
            } catch (SQLException e){
                //System.out.println("sql fejl");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void showTables(Connection connect){

        System.out.println("Showing all tables");

        String sql = "show tables";

        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            //statement.setString(1,"value1");
            ResultSet res = statement.executeQuery();


            int i = 1;
            try {
                while (res.next()) {
                    System.out.println(res.getString(i));
                    i++;
                }
            } catch (SQLException e){
                //System.out.println("sql fejl");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void testAfAllprocesses(){
        DBUtil.allProcesses(0,0);




    }



}

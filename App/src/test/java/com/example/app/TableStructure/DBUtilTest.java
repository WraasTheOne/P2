package com.example.app.TableStructure;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {


    @Test
    void getConnection(){
        Connection conn = DBUtil.getConnection();

        assertNotNull(conn);

    }

    @Test
    void getsingleValue() {


        assertEquals(10,DBUtil.getsingleValue("Bigbags",1));


    }

    @Test
    void findUser() {
        HashTable.makeHashTables();
        boolean expected = true;
        assertEquals(expected, DBUtil.findUser("test","test","kooperation"));

    }

    @Test
    void insertBigbag() {

        assertEquals("Big Bag created",DBUtil.insertBigbag(1,1,"test",2,"test"));

    }


    @Test
    void getIntCoulmnHighestData() {


        assertEquals(18,DBUtil.getIntCoulmnHighestData("Wallecubes","WID"));

    }

    @Test
    void addUser() {
        HashTable.makeHashTables();

        assertEquals("User already exists",DBUtil.addUser("test","test","kooperation"));

    }

    @Test
    void removeUser() {

        assertEquals("User removed", DBUtil.removeUser("test2", "kooperation"));
    }
}
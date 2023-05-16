package com.example.app.TableStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void makeHashTables() {
        boolean expected = true;

        boolean ans = HashTable.makeHashTables();

        assertEquals(expected,ans);
    }

    @Test
    void getLocationHashValue() {
        HashTable.makeHashTables();

        assertEquals(1,HashTable.getLocationHashValue("Location 1"));
    }

    @Test
    void getProcessHashValue() {
        HashTable.makeHashTables();

        assertEquals(1,HashTable.getProcessHashValue("Collection"));
    }

    @Test
    void getUserTypeHashValue() {
        HashTable.makeHashTables();

        assertEquals("KID",HashTable.getUserTypeHashValue("kooperation"));
    }

    @Test
    void getLocationNames() {
        HashTable.makeHashTables();
        String[] locationNames  = {"Location 1", "Location 2","Location 3"};

        assertArrayEquals(locationNames,HashTable.getLocationNames());
    }

    @Test
    void getProcesNames() {
        HashTable.makeHashTables();

        String[] procesNames  = {"Collection", "Stacking","Sorting","Label","Storage CORPS","Centercorp Delivery","Compress and weighing","Label compressed weight","Storage centerCORP","Selling"};

        assertArrayEquals(procesNames,HashTable.getProcesNames());
    }

    @Test
    void getMaterialType() {
        HashTable.makeHashTables();

        String[] materialType = {"Plastic","Metal", "Cardboard"};

        assertArrayEquals(materialType,HashTable.getMaterialType());

    }
}
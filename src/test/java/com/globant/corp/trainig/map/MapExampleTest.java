package com.globant.corp.trainig.map;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MapExampleTest {

    private MapExample mapExample;

    @Test
    public void computeIfAbsentTest() {
        final int initialSize = mapExample.printMapWithEntrySet();
        System.out.println("--------------------------------------------------------------");
        final int putExisting = mapExample.computeIfAbsent("key1", "Value1Changed");
        System.out.println("--------------------------------------------------------------");
        assertEquals(initialSize, putExisting);
        final int putNew = mapExample.computeIfAbsent("key5", "Value5Changed");
        assertEquals(initialSize + 1, putNew);
    }

    @Test
    public void computeIfPresentTest() {
        final int initialSize = mapExample.printMapWithEntrySet();
        System.out.println("--------------------------------------------------------------");
        final int putExisting = mapExample.computeIfPresent("key1", "Value1Changed");
        System.out.println("--------------------------------------------------------------");
        assertEquals(initialSize, putExisting);
        final int putNew = mapExample.computeIfPresent("key5", "Value5Changed");
        assertEquals(initialSize, putNew);
    }

    @Test
    public void getNotNullValueTest() {
        final String existingKey = "key1";
        final String existingValue = "value1";
        final String nonExistingKey = "key5";

        assertEquals(existingValue, mapExample.getNotNullValue(existingKey));
        assertEquals(MapExample.DEFAULT_VALUE, mapExample.getNotNullValue(nonExistingKey));
    }

    @Before
    public void init() {
        mapExample = new MapExample();
    }

    @Test
    public void printMapWithEntrySetTest() {
        assertEquals(mapExample.mapSize(), mapExample.printMapWithEntrySet());
    }

    @Test
    public void printMapWithForEachTest() {
        assertEquals(mapExample.mapSize(), mapExample.printMapWithForEach());
    }

    @Test
    public void putIfAbsentTest() {
        final int initialSize = mapExample.printMapWithEntrySet();
        System.out.println("--------------------------------------------------------------");
        final int putExisting = mapExample.putIfAbsent("key1", "Value1Changed");
        System.out.println("--------------------------------------------------------------");
        assertEquals(initialSize, putExisting);
        final int putNew = mapExample.putIfAbsent("key5", "Value5Changed");
        assertEquals(initialSize + 1, putNew);
    }
}

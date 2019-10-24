package me.karthikrao.hash.map;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    @Test
    public void add() {
        HashMap map = new HashMap(20);
        assertEquals(0, map.size());

        map.add(1, 100);
        assertEquals(1, map.size());
        map.print();

        map.add(2, 200);
        assertEquals(2, map.size());
        map.print();

    }

    @Test
    @Ignore
    public void handleAddCollision() {
        HashMap map = new HashMap(129);

        map.add(1, 100);
        map.add(2, 600);
        map.add(12, 700);
        map.add(564, 800);
        map.add(34, 900);
        map.add(982, 2000);
        map.add(24, 300);

        map.print();
        assertEquals(2000, map.get(982));
        assertEquals(900, map.get(34));
        assertEquals(800, map.get(564));
    }
}
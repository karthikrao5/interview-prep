package me.karthikrao.lruCache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    @Test
    public void add() {
        Cache cache = new Cache(4);
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        cache.put(4, 400);

        assertEquals(100, cache.get(1));
        cache.put(5, 500);
        assertEquals(-1, cache.get(2));

        assertEquals(300, cache.get(3));
    }

    @Test
    void keyDuplicate() {
        Cache cache = new Cache(2);

        assertEquals(-1, cache.get(2));

        cache.put(2, 6);
        assertEquals(-1, cache.get(1));

        cache.put(1, 5);
        cache.put(1, 2);

        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));
    }

    @Test
    void firstKeyDuplicate() {
        Cache cache = new Cache(2);

        cache.put(2, 1);
        cache.put(2, 2);
        assertEquals(2, cache.get(2));
    }
}
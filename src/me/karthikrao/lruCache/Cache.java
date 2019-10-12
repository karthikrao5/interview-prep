package me.karthikrao.lruCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class Cache {
    private int capacity;
    private LinkedList<Item> cache;
    private HashMap<Integer, Integer> map;

    Cache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedList<>();
        map = new HashMap<>();
    }

    int get(int key) {
        Iterator it = cache.iterator();
        int index = 0;
        Item found = null;
        while (it.hasNext()) {
            Item curr = (Item) it.next();
            if (curr.key == key) {
                found = curr;
                break;
            }
            index++;
        }

        if (found != null) {
            cache.remove(index);
            cache.addFirst(found);
            return found.value;
        }

        return -1;
    }

    void put(int key, int value) {
        Iterator it = cache.iterator();
        Item found = null;
        int index = 0;
        while (it.hasNext()) {
            Item curr = (Item) it.next();
            if (curr.key == key) {
                found = curr;
                break;
            }
            index++;
        }
        if (found != null) {
            found.value = value;
            cache.remove(index);
            cache.addFirst(found);
        } else {
            if (cache.size() >= capacity) {
                cache.removeLast();
            }
            cache.addFirst(new Item(key, value));
        }
    }

    private static class Item {
        int key;
        int value;

        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    void print() {
        System.out.println("======================start cache=================");
        for (Item curr : cache) {
            System.out.println(String.format("(%d, %d)", curr.key, curr.value));
        }
        System.out.println("======================end cache=================");
    }
}

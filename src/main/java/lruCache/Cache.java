package lruCache;

import java.util.Iterator;
import java.util.LinkedList;

public class Cache {
    private int capacity;
    private LinkedList<Item> cache;

    public Cache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedList<>();
    }

    /**
     * @param key of item to find
     * @return value of item if the entry exists, -1 if it does not
     *         move found item to top of list (most recently used)
     */
    public int get(int key) {
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

    /**
     * @param key key of item to put
     * @param value value of item to put
     *
     * if key already exists, replace the value and move it to top of list
     *              must not go over capacity
     */
    public void put(int key, int value) {
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

    public void print() {
        System.out.println("======================start cache=================");
        for (Item curr : cache) {
            System.out.println(String.format("(%d, %d)", curr.key, curr.value));
        }
        System.out.println("======================end cache=================");
    }
}

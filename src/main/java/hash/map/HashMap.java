package hash.map;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class HashMap {
    private float loadFactor = 0.75f;
    private int capacity;
    private int size;
    private Entry[] arr;

    public HashMap(int capacity) {
        this.capacity = capacity;
        arr = new Entry[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * @param key of entry
     * @return value of object at the key
     */
    public int get(int key) {
        LocalDateTime start = LocalDateTime.now();

        int index = hash(key) % capacity;
        Entry foundEntry = arr[index];
        if (foundEntry != null) {
            while (foundEntry != null && foundEntry.key != key) {
                foundEntry = foundEntry.next;
            }
        } else {
            System.out.println("Microseconds to get " + foundEntry.key + " to map is " + getTimeElapsed(start, LocalDateTime.now()));
            return foundEntry.value;
        }

        return -1;
    }

    public void add(int key, int value) {
        LocalDateTime start = LocalDateTime.now();

        Entry node = new Entry(key, value);
        int hashedKey = hash(key);
        int index = hashedKey % this.capacity;

//        check if there already exists a bucket at the index
        Entry currEntry = arr[index];
        if (currEntry != null) {
            while(currEntry.next != null) {
                //got to end of list
                currEntry = currEntry.next;
            }
            currEntry.next = node;
        } else {
            arr[index] = node;
        }

        size++;
        System.out.println("Microseconds to add " + arr[index].value + " to map is " + getTimeElapsed(start, LocalDateTime.now()));
    }

    private static long getTimeElapsed(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return Math.round(duration.getNano() / 1000);
    }

    private int hash(int key) {
        return Objects.hash(key);
    }

    public void print() {
        for (Entry entry : arr) {
            if (entry != null) {
                Entry curr = entry;
                while (curr != null) {
                    System.out.println(String.format("(key: %d, value: %d)", curr.key, curr.value));
                    curr = curr.next;
                }
            }
        }
    }

    static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

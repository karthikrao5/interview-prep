package lruCache;

import java.util.HashMap;

public class FasterCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node start,end;

    public FasterCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        start = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        end = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        start.right = end;
        end.left = start;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node found = map.get(key);
            removeFromMiddle(found);
            addToTop(found);
//            print();
            return found.value;
        }
//        print();
        return -1;
    }

    /**
     * @param key key to add
     * @param value value to add
     *              if key exists, update value and move to top
     */
    public void put(int key, int value) {
//        check if key exists
        if(map.containsKey(key)) {
//            update value and move to top
            Node curr = map.get(key);
            curr.value = value;
            removeFromMiddle(curr);
            addToTop(curr);
        } else {
//            check capacity
            Node newNode = new Node(key, value);
            if (map.size() < capacity) {
                addToTop(newNode);
            } else {
                removeFromEnd();
                addToTop(newNode);
            }
        }
//        print();
    }

    private void addToTop(Node curr) {
        Node oldFirst = start.right;

        start.right = curr;
        curr.left = start;

        curr.right = oldFirst;
        oldFirst.left = curr;
        map.put(curr.key, curr);
    }

    private void removeFromEnd() {
        Node oldLast = end.left;
        map.remove(oldLast.key);

        Node secondFromLast = end.left.left;
        secondFromLast.right = end;
        end.left = secondFromLast;
    }

    private void removeFromMiddle(Node curr) {
        if (curr.right == end) {
            removeFromEnd();
            return;
        }
        curr.left.right = curr.right;
        curr.right.left = curr.left;
    }

    public void print() {
        System.out.println("PRINTING_CACHE");
        Node curr = start.right;
        while(curr != end) {
            System.out.println(String.format("(key: %d, value: %d)", curr.key, curr.value));
            curr = curr.right;
        }
        System.out.println("END_PRINTING_CACHE");
    }

    private static class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

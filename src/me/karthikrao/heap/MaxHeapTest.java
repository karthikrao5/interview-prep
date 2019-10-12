package me.karthikrao.heap;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    void add() {
        MaxHeap heap = new MaxHeap(10);
        assertEquals(0, heap.size());

        heap.add(10);
        assertEquals(1, heap.size());

        heap.add(20);
        assertEquals(2, heap.size());
    }

    @Test
    void getMax() {
        MaxHeap heap = new MaxHeap(10);
        heap.add(10);
        assertEquals(10, heap.getMax());

        heap.add(20);
        assertEquals(20, heap.getMax());

        heap.add(15);
        assertEquals(20, heap.getMax());

        heap.add(50);
        assertEquals(50, heap.getMax());

        heap.add(17);
        assertEquals(50, heap.getMax());

        heap.add(90);
        assertEquals(90, heap.getMax());
    }

    @Test
    void delete() {
        MaxHeap heap = new MaxHeap(10);
        heap.add(10);
        heap.add(20);
        heap.add(15);
        heap.add(50);
        heap.add(17);
        heap.add(90);

        assertTrue(heap.delete(90));

        assertEquals(5, heap.size());
        assertEquals(50, heap.getMax());

        assertTrue(heap.delete(50));
        assertEquals(4, heap.size());
        assertEquals(20, heap.getMax());
    }
}
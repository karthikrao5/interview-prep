package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void case1() {
        MinStack stack = new MinStack();

        stack.push(-10);
        stack.push(14);

        assertEquals(-10, stack.getMin());
        assertEquals(-10, stack.getMin());

        stack.push(-20);
        assertEquals(-20, stack.getMin());
        assertEquals(-20, stack.getMin());
        assertEquals(-20, stack.top());
        assertEquals(-20, stack.getMin());

        stack.pop();
        stack.push(10);
        stack.push(-7);

        assertEquals(-10, stack.getMin());
        stack.push(-7);

        stack.pop();
        assertEquals(-7, stack.top());
        assertEquals(-10, stack.getMin());
        stack.pop();
    }
}
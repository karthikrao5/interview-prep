package algorithms;

public class MinStack {
    class MinStackNode {
        int val;
        int minVal;

        MinStackNode(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }

        @Override
        public String toString() {
            return String.format("node(val: %d, minVal: %d)", this.val, this.minVal);
        }
    }

    MinStackNode[] arr;
    int stackPtr;


    /** initialize your data structure here. */
    public MinStack() {
        arr = new MinStackNode[1000];
        stackPtr = 0;
    }

    public void push(int x) {
        if (x > Integer.MAX_VALUE) {
            return;
        }
        if (stackPtr < arr.length) {
            if (stackPtr == 0) {
                arr[stackPtr] = new MinStackNode(x, x);
            } else {
                int currMinVal = arr[stackPtr - 1].minVal;
                if (x < currMinVal) {
                    currMinVal = x;
                }
                arr[stackPtr] = new MinStackNode(x, currMinVal);
            }
            stackPtr++;
            System.out.println("top of stack: " + arr[stackPtr - 1].toString());
        }
    }

    public void pop() {
        if (stackPtr > 0) {
            stackPtr--;
        }
    }

    public int top() {
        return arr[stackPtr - 1].val;
    }

    public int getMin() {
        return arr[stackPtr - 1].minVal;
    }
}
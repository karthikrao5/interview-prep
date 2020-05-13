package heap;

public class MaxHeap {
    private int[] arr;
    private int size;

    public MaxHeap(int cap) {
        this.arr = new int[cap];
        this.size = 0;
    }

    public boolean add(int num) {
        arr[size] = num;

        int currIndex = size;
        while(arr[currIndex] > arr[parent(currIndex)]) {
            swap(currIndex, parent(currIndex));
            currIndex = parent(currIndex);
        }

        size++;
        return true;
    }

    public int getMax() {
        return arr[0];
    }

    public boolean delete(int num) {
        int numIndex = findIndex(num);
        if (numIndex < 0) {
            return false;
        }

        arr[numIndex] = arr[--size];

        while(arr[numIndex] < arr[left(numIndex)] || arr[numIndex] < arr[right(numIndex)]) {
            swap(numIndex, greaterChildIndex(numIndex));
            numIndex = greaterChildIndex(numIndex);
        }
        return true;
    }

    public int size() {
        return size;
    }

    private int greaterChildIndex(int parentInd) {
        int left = arr[left(parentInd)];
        int right = arr[right(parentInd)];
        return right > left ? right(parentInd) : left(parentInd);
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int indA, int indB) {
        int temp = arr[indB];
        arr[indB] = arr[indA];
        arr[indA] = temp;
    }

    private int findIndex(int num) {
        int numIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == num) {
                numIndex = i;
            }
        }
        return numIndex;
    }
}
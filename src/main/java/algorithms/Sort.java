package algorithms;

public class Sort {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public void quickSort() {
        quickSort(arr, 0, arr.length);
    }

    private int quickSort(int[] arr, int high, int low) {
        int midpoint = (high - low) / 2;

        return 0;
    }
}

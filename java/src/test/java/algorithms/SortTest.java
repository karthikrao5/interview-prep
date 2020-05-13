package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    @Test
    void mergeSort1() {
        int[] arr = new int[] {5,3,11,7,34,5,8};
        Sort sorter = new Sort(arr);
        sorter.quickSort();
        assertFalse(true);
    }
}
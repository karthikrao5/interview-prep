import algorithms.Algorithms;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlgorithmsTest {

    @Test
    @Disabled
    void reverse() {
        assertEquals(321, Algorithms.reverse(123));
        assertEquals(-123, Algorithms.reverse(-321));
        assertEquals(21, Algorithms.reverse(120));

        assertEquals(0, Algorithms.reverse(1534236469));
    }

    @Test
    void zigzag() {
        assertEquals("PAYPALISHIRING", Algorithms.zigzag("PAYPALISHIRING", 1));
        assertEquals("PYAIHRNAPLSIIG", Algorithms.zigzag("PAYPALISHIRING", 2));
        assertEquals("PAHNAPLSIIGYIR", Algorithms.zigzag("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", Algorithms.zigzag("PAYPALISHIRING", 4));
        assertEquals("A", Algorithms.zigzag("A", 3));
        assertEquals("", Algorithms.zigzag("", 3));
    }

    @Test
    void threeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, 4};

        List<List<Integer>> expectedOutput = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(-1, 0, 1));
            add(Arrays.asList(-1, 2, -1));
        }};

        List<List<Integer>> actualBruteForce = Algorithms.bruteForceThreeSum(nums);
        List<List<Integer>> actualOutput = Algorithms.threeSum(nums);

        actualBruteForce.forEach(triplet -> triplet.sort(Comparator.comparing(Integer::valueOf)));
        expectedOutput.forEach(triplet -> triplet.sort(Comparator.comparing(Integer::valueOf)));

        assertEquals(expectedOutput.size(), actualBruteForce.size());
        assertTrue(actualBruteForce.containsAll(expectedOutput));

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertTrue(actualOutput.containsAll(expectedOutput));
    }

}

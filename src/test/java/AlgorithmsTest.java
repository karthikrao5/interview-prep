import algorithms.Algorithms;
import algorithms.TreeNode;
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

    @Test
    void maximalSquareCase1() {
        char[][] arr = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int maxSizeSquare = Algorithms.maximalSquare(arr);
        assertEquals(4, maxSizeSquare);
    }

    @Test
    void maxSquareCase2() {
        char[][] arr2 = {
                {1, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}
        };

        int maxSizeSquare = Algorithms.maximalSquare(arr2);
        assertEquals(9, maxSizeSquare);
    }

    @Test
    void maxSquareCase3() {
        char[][] arr3 = {{0}};
        int maxSizeSquare = Algorithms.maximalSquare(arr3);
        assertEquals(0, maxSizeSquare);
    }

    @Test
    void maxSquareCase4() {
        char[][] arr4 = {{1}};
        int maxSizeSquare = Algorithms.maximalSquare(arr4);
        assertEquals(1, maxSizeSquare);
    }

    @Test
    void maxSquareCase5() {
        char[][] arr5 = {};
        int maxSizeSquare = Algorithms.maximalSquare(arr5);
        assertEquals(0, maxSizeSquare);
    }

    @Test
    void maxSquareCase6() {
        char[][] arr6 = {
                {0, 1}
        };
        int maxSizeSquare = Algorithms.maximalSquare(arr6);
        assertEquals(1, maxSizeSquare);
    }

    @Test
    void maxSquareCase7() {
        char[][] arr7 = {
                {0},
                {1}
        };
        int maxSizeSquare = Algorithms.maximalSquare(arr7);
        assertEquals(1, maxSizeSquare);
    }

    @Test
    void countNodes() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);

        assertEquals(6, Algorithms.countNodes(node1));
    }

    @Test
    void countNodesSingleNode() {
        assertEquals(1, Algorithms.countNodes(new TreeNode(1)));
    }

    @Test
    void countNodesEmptyRoot() {
        assertEquals(0, Algorithms.countNodes(null));
    }

    @Test
    void cowsAndBullsCase1() {
        String secret = "1807";
        String guess = "7810";

        assertEquals("1A3B", Algorithms.getHint(secret, guess));
    }

    @Test
    void cowsAndBullsCase2() {
        String secret = "1123";
        String guess = "0111";

        assertEquals("1A1B", Algorithms.getHint(secret, guess));
    }

    @Test
    void cowsAndBullsCase3() {
        String secret = "1122";
        String guess = "2211";

        assertEquals("0A4B", Algorithms.getHint(secret, guess));
    }

    @Test
    void cowsAndBullsCase4() {
        String secret = "11";
        String guess = "10";

        assertEquals("1A0B", Algorithms.getHint(secret, guess));
    }
}

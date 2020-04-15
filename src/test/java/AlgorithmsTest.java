import algorithms.Algorithms;
import algorithms.TreeNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    @Disabled
    void cowsAndBullsCase4() {
        String secret = "11";
        String guess = "10";

        assertEquals("1A0B", Algorithms.getHint(secret, guess));
    }

    @Test
    void calcEquationCase1() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] solution = Algorithms.calcEquation(equations, values, queries);
        double[] expectedSolution = new double[]{
                6.0,
                0.5,
                -1.0,
                1.0,
                -1.0
        };

        System.out.println("output: " + Arrays.toString(solution));

        assertEquals(expectedSolution.length, solution.length);

        for (int i = 0; i < solution.length; i++) {
            assertEquals(expectedSolution[i], solution[i]);
        }
    }

    @Test
    void calcEquationCase2() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("x1", "x2"),
                Arrays.asList("x2", "x3"),
                Arrays.asList("x3", "x4"),
                Arrays.asList("x4", "x5")
        );

        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("x1", "x5"),
                Arrays.asList("x5", "x2"),
                Arrays.asList("x2", "x4"),
                Arrays.asList("x2", "x2"),
                Arrays.asList("x2", "x9"),
                Arrays.asList("x9", "x9")
        );

        double[] solution = Algorithms.calcEquation(equations, values, queries);
        double[] expectedSolution = new double[]{
                360.00000,
                0.00833,
                20.00000,
                1.00000,
                -1.00000,
                -1.00000
        };

        System.out.println("output: " + Arrays.toString(solution));

        assertEquals(expectedSolution.length, solution.length);

        for (int i = 0; i < solution.length; i++) {
            assertEquals(expectedSolution[i], solution[i], 0.00001);
        }
    }

    @Test
    void backspaceStringCompareCase1() {
        String S = "ab#c";
        String T = "ad#c";

        assertTrue(Algorithms.backspaceCompare(S, T));
    }

    @Test
    void backspaceStringCompareCase2() {
        String S = "bxj##tw";
        String T = "bxo#j##tw";

        assertTrue(Algorithms.backspaceCompare(S, T));
    }

    @Test
    void backspaceStringCompareCase3() {
        String S = "";
        String T = "#";
        assertTrue(Algorithms.backspaceCompare(S, T));
    }

    @Test
    void backspaceStringCompareCase4() {
        String S = "";
        String T = "";
        assertTrue(Algorithms.backspaceCompare(S, T));
    }

    @Test
    void backspaceStringCompareCase5() {
        String S = "a#c";
        String T = "b";
        assertFalse(Algorithms.backspaceCompare(S, T));
    }

    @Test
    void sortedArrayMergeCase1() {
        int[] a = new int[12];
        a[0] = 2;
        a[1] = 5;
        a[2] = 6;
        a[3] = 7;
        a[4] = 10;
        a[5] = 15;

        System.out.println(a.length);

        int[] b = new int[]{1, 3, 4, 8, 9, 12};

        Algorithms.sortedMerge(a, b, 5, 5);
        System.out.println(Arrays.toString(a));
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void sortedArrayMergeCase2() {
        int[] a = new int[12];
        a[0] = 2;
        a[1] = 5;
        a[2] = 6;
        a[3] = 7;

        System.out.println(a.length);

        int[] b = new int[]{1, 3, 4, 8, 9, 12};

        Algorithms.sortedMerge(a, b, 3, 5);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void sortedArrayMergeCase3() {
        int[] a = new int[6];
        int[] b = new int[]{1, 3, 4, 8, 9, 12};

        Algorithms.sortedMerge(a, b, 0, 5);
        int[] expected = new int[]{1, 3, 4, 8, 9, 12};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void sortedArrayMergeCase4() {
        int[] a = new int[0];
        int[] b = new int[0];

        Algorithms.sortedMerge(a, b, 0, 0);
        assertEquals(0, a[0]);
    }

    @Test
    void dominoTest1() {
        int[] A = new int[]{2, 1, 2, 4, 2, 2};
        int[] B = new int[]{5, 2, 6, 2, 3, 2};

        assertEquals(2, Algorithms.minDominoRotations(A, B));
    }

    @Test
    void dominoTest2() {
        int[] A = new int[]{2, 1, 2, 4, 2, 2};
        int[] B = new int[]{5, 4, 6, 2, 3, 2};

        assertEquals(-1, Algorithms.minDominoRotations(A, B));
    }

    @Test
    void dominoTest3() {
        int[] A = new int[]{3, 5, 1, 2, 3};
        int[] B = new int[]{3, 6, 3, 3, 4};

        assertEquals(-1, Algorithms.minDominoRotations(A, B));
    }
}

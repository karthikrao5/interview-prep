package algorithms;

import java.util.*;

public class Algorithms {
    public static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
            if (reverse > Integer.MAX_VALUE - 1 || reverse < Integer.MIN_VALUE + 1)
                return 0;
        }

        return isNegative ? (-1 * reverse) : reverse;
    }

    /**
     * solution to the medium leetcode problem
     * https://leetcode.com/problems/zigzag-conversion
     */
    public static String zigzag(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        int numColumns = (int) Math.ceil(s.length() / 2) + 1;
        char[][] tbl = new char[numRows][numColumns];
        StringBuilder sb = new StringBuilder();

        int strCount = 0;
        for (int col = 0; col < numColumns; col++) {
            if (strCount < s.length()) {
                if (col % (numRows - 1) == 0) {
                    for (int i = 0; i < numRows; i++) {
                        if (strCount < s.length()) {
                            tbl[i][col] = s.charAt(strCount);
                            strCount++;
                        }
                    }
                } else {
                    tbl[(numRows - 1) - (col % (numRows - 1))][col] = s.charAt(strCount);
                    strCount++;
                }
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                if (tbl[row][col] != '\0') {
                    sb.append(String.valueOf(tbl[row][col]));
                }
            }
        }

        return sb.toString();
    }

    /**
     * https://leetcode.com/problems/3sum/
     * O(n^3) brute force threeSum
     * Ensures no duplicates
     */
    public static List<List<Integer>> bruteForceThreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return output;
    }

    /**
     * O(n^2)
     * https://leetcode.com/problems/3sum/
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            int T = -1 * nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == T) {
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    //skip over all duplicates of j
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else if (nums[j] + nums[k] > T) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return output;
    }

    /**
     * Maximal square leet code mediuum #221
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        //dp[i][j] is the length of the side of a square from bottom right corner
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }

        int max = 0;
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    dp[row][col] = Math.min(Math.min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }

        return max * max;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int count = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (curr.left != null) {
                q.add(curr.left);
            }

            count++;
        }

        return count;
    }

    private static void print2dArray(int[][] input) {
        System.out.println("Printing array");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}

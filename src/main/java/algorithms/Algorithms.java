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

    /**
     * unfinished
     *
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) {
        int cows = 0;
        int bulls = 0;

        HashMap<Character, Integer> secretMap = new HashMap();

        //check positions
        for (int i = 0; i < guess.length(); i++) {
            Character sChar = secret.charAt(i);
            Character gChar = guess.charAt(i);

            if (sChar == gChar) {
                bulls++;
            } else {
                if (secretMap.containsKey(sChar)) {
                    //count the number of duplicates in the secret
                    secretMap.put(sChar, secretMap.get(sChar) + 1);
                } else {
                    secretMap.put(sChar, 1);
                }
            }
        }

        //go thru guess and increment cows when a value is found as a key and decrement it
        for (int i = 0; i < guess.length(); i++) {
            Character sChar = secret.charAt(i);
            Character gChar = guess.charAt(i);

            if (secretMap.containsKey(gChar)) {
                int newQuantity = secretMap.get(gChar) - 1;
                cows++;

                if (newQuantity == 0) {
                    secretMap.remove(gChar);
                } else {
                    secretMap.put(gChar, newQuantity);
                }
            }
        }
        return bulls + "A" + cows + "B";
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

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] output = new double[queries.size()];

        HashMap<String, HashMap<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String start = equation.get(0);
            String end = equation.get(1);
            double val = values[i];

            map.computeIfAbsent(start, ignore -> new HashMap<String, Double>() {{
                put(start, 1.0);
            }}).put(end, val);
            map.computeIfAbsent(end, ignore -> new HashMap<String, Double>() {{
                put(end, 1.0);
            }}).put(start, 1.0 / val);
        }


        int counter = 0;
        for (List<String> query : queries) {
            // perform DFS to find the end node and return the accumulated value
            HashSet<String> visited = new HashSet<>();

            output[counter] = dfs(query.get(0), query.get(1), map, visited);
            counter++;
        }

        return output;
    }

    private static double dfs(
            String curr,
            String end,
            HashMap<String, HashMap<String, Double>> map,
            HashSet<String> visited
    ) {
        visited.add(curr);

        if (map.containsKey(curr)) {
            //base case
            if (map.get(curr).containsKey(end)) {
                return map.get(curr).get(end);
            }

            for (String child : map.get(curr).keySet()) {
                if (!visited.contains(child)) {
                    double dfs = dfs(child, end, map, visited);
                    if (dfs > 0) return dfs * map.get(curr).get(child);
                }
            }

            return -1.0;
        }

//        should never get here. only way is if child has no children which it cant
        return -1.0;
    }


    /**
     * Leetcode Easy 844
     * Backspace String Compare
     * Given two strings S and T, return if they are equal when both
     * are typed into empty text editors. # means a backspace character.
     *
     * @param S
     * @param T
     * @return if the two strings are equal after removing the backspace characters
     */
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int counter = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '#') {
                counter++;
            } else {
                if (counter > 0) {
                    counter--;
                    continue;
                }
                sb1.insert(0, S.charAt(i));
            }
        }

        counter = 0;
        for (int i = T.length() - 1; i >= 0; i--) {
            if (T.charAt(i) == '#') {
                counter++;
            } else {
                if (counter > 0) {
                    counter--;
                    continue;
                }
                sb2.insert(0, T.charAt(i));
            }
        }

        return sb1.toString().compareTo(sb2.toString()) == 0;
    }

    public static void sortedMerge(int[] a, int[] b, int lastA, int lastB) {
        if (a == null || b == null || a.length <= 0 || b.length <= 0) {
            return;
        }

        int mergedInd = lastA + lastB + 1;


        //keep going until all of B is merged
        while (lastB >= 0) {
            if (lastA >= 0 && a[lastA] >= b[lastB]) {
                a[mergedInd] = a[lastA];
                lastA--;
            } else {
                a[mergedInd] = b[lastB];
                lastB--;
            }
            mergedInd--;
        }
    }
}

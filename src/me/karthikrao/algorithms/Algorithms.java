package me.karthikrao.algorithms;

public class Algorithms {
    static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        int reverse = 0;
        while(x > 0) {
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
}
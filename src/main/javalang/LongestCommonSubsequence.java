package javalang;

public class LongestCommonSubsequence {


    // 1143. Longest Common Subsequence
    // https://leetcode.com/problems/longest-common-subsequence/
    class Solution {

        // approach 4 with space optimization
        // this approach makes use of the fact that actual DP solution uses only 1 last column of DP matrix to calculate current column
        public int longestCommonSubsequence(String text1, String text2) {

            if (text1 == null || text2 == null) {
                return 0;
            }

            char[] c1 = text1.toCharArray();
            char[] c2 = text2.toCharArray();

            int[] prev = new int[c1.length + 1];

            // column first
            for (int col = c2.length - 1; col >= 0; col--) {

                int[] curr = new int[c1.length + 1];

                for (int row = c1.length - 1; row >= 0; row--) {
                    if (c1[row] == c2[col]) {
                        curr[row] = prev[row + 1] + 1;
                    } else {
                        curr[row] = Math.max(curr[row + 1], prev[row]);
                    }
                }

                // IMPORTANT
                prev = curr;
            }
            return prev[0];
        }

        // approach 3
        // bottom up DP solution
        public int longestCommonSubsequence_withoutSpaceOptimization(String text1, String text2) {

            if (text1 == null || text2 == null) {
                return 0;
            }

            char[] c1 = text1.toCharArray();
            char[] c2 = text2.toCharArray();
            int[][] dp = new int[c1.length + 1][c2.length + 1];

            for (int row = c1.length - 1; row >= 0; row--) {
                for (int col = c2.length - 1; col >= 0; col--) {
                    if (c1[row] == c2[col]) {
                        dp[row][col] = dp[row + 1][col + 1] + 1;
                    } else {
                        dp[row][col] = Math.max(dp[row][col + 1], dp[row + 1][col]);
                    }
                }
            }
            return dp[0][0];
        }


        // this is approach 2 - recursive
        // top down solution M*N space and time
        public int longestCommonSubsequence_recursive(String text1, String text2) {
            if (text1 == null || text2 == null) {
                return 0;
            }

            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int[][] dp = new int[chars1.length][chars2.length];

            return findSubSequence_recursive(chars1, 0, chars2, 0, dp);
        }

        private int findSubSequence_recursive(char[] chars1, int i, char[] chars2, int j, int[][] dp) {

            if (i >= chars1.length || j >= chars2.length) {
                return 0;
            }

            if (dp[i][j] != 0) {
                return dp[i][j];
            }

            int length = Integer.MIN_VALUE;
            if (chars1[i] == chars2[j]) {
                length = findSubSequence_recursive(chars1, i + 1, chars2, j + 1, dp) + 1;
            } else {
                length = Math.max(findSubSequence_recursive(chars1, i + 1, chars2, j, dp), length);
                length = Math.max(findSubSequence_recursive(chars1, i, chars2, j + 1, dp), length);
            }

            dp[i][j] = length;
            return length;
        }
    }
}

package javasolutions.dp;

// 516. Longest Palindromic Subsequence
// https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {
    class Solution {

        // TODO: there is a O(N) space solution, look at it later
        // dp[i][j] = longest palindromic subsequence between i and j
        // Call the function top-down recursively for each i,j will base cases are reached, however, values
        // are filled bottoms up
        // time = O(n^2) since every entry in dp matrix is filled once
        // space = O(n^2) for dp matrix
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }

            char[] chars = s.toCharArray();
            int[][] dp =  new int[chars.length][chars.length];

            // filling array is not necessary since smallest solution = 0 which is > 0 anyways, so each cell is still visited only once
            // for (int[] arr : dp) {
            //     Arrays.fill(arr, -1);
            // }

            return doDP(chars, dp, 0, chars.length-1);
        }

        private int doDP(char[] chars, int[][]dp, int left , int right) {
            // base case
            if (left > right) {
                return 0;
            }

            if (dp[left][right] != 0) {
                return dp[left][right];
            }

            if (left == right) {
                dp[left][right] = 1;
                return 1;
            }

            // if adjacent numbers, then return if they are same or not
            if (right - left == 1) {
                int result = chars[left] == chars[right] ? 2 : 1;
                dp[left][right] = result;
                return result;
            }

            int max = Integer.MIN_VALUE;
            if (chars[left] == chars[right]) {
                // GREEDILY include both
                max = Math.max(max, doDP(chars, dp, left + 1, right -1) + 2);
            } else {
                // skip one and take max of both
                max = Math.max(max, doDP(chars, dp, left + 1, right));
                max = Math.max(max, doDP(chars, dp, left, right - 1));
            }
            // Dont forget to record so that we never repeat this calculation!
            dp[left][right] = max;
            return max;
        }
    }
}

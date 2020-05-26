package javalang;

// 516. Longest Palindromic Subsequence
// https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {
    class Solution {

        // TODO: there is a O(N) space solution, look at it
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

            int left = 0;
            int right = chars.length - 1;
            int[][] dp =  new int[chars.length][chars.length];

            // filling array is not necessary since smallest solution = 0 which is > 0 anyways, so each cell is still visited only once
            // for (int[] arr : dp) {
            //     Arrays.fill(arr, -1);
            // }

            return doDP(chars, dp, left, right);
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
                // include both
                max = Math.max(max, doDP(chars, dp, left + 1, right -1) + 2);
            } else {
                // skip one
                max = Math.max(max, doDP(chars, dp, left + 1, right));
                max = Math.max(max, doDP(chars, dp, left, right - 1));
            }
            dp[left][right] = max;
            return max;
        }
    }
}

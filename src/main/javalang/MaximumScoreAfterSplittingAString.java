package javalang;

public class MaximumScoreAfterSplittingAString {
    // 1422. Maximum Score After Splitting a String
// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

// array iteration from both sides to yield counts for what we want and then a final iteration to caculate max value

    class Solution {
        public int maxScore(String s) {
            if (s == null || s.length() == 1) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int n = chars.length;
            // OPTIMIZATION: could remove one of these arrays
            int[] left = new int[n]; // number of zeroes from left
            int[] right = new int[n]; // number of ones from right

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == '0') {
                    count++;
                }
                left[i] = count;
            }

            count = 0;
            for (int i = right.length - 1; i >= 0; i--) {
                if (chars[i] == '1') {
                    count++;
                }
                right[i] = count;
            }

            count = 0;
            for (int i = 0; i < left.length; i++) {

                if (i == 0) {
                    // only zeroes count since we want a non-empty string on each side of the result
                    count = Math.max(count, left[i]);
                } else if (i == n - 1) {
                    // only ones count since we want a non-empty string on each side of the result
                    count = Math.max(count, right[i]);
                } else {
                    count = Math.max(left[i] + right[i], count);
                }
            }
            return count;
        }
    }

}

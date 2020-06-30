package javasolutions.dp;

public class MaximumLengthOfRepeatedSubarray_OR_LongestCommonSubstring {
    // 718. Maximum Length of Repeated Subarray
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// Medium DP
// IMPORTANT: Same solution can be applied for Longest Common Substring given 2 strings!!
    class Solution {

        // DP solution that is space optimized. The unoptimized-space version is below
        // DP[i][j] = 0 or 1+DP[i+1][j+1]
        // Since we use only 2 rows to calculate the result, we can eliminate the M*N matrix and use 2 M matrices.
        // Algo: the optimal subsolution for base case can be carried forward. E.g. A=123412 and B=12 then solution for last 2 in A can be carried forward for last 1 in A. Same for first 1 and 2 in A.
        // This tells me that the subsolution keeps changing for each row of A without maintaining a global state or answer. Since the last occurrence of 1 does not necessarily affect first occurrence of 1.
        // In interview, you may come to this realization if YOU TRY TO FIND THE SUBOPTIMAL SOLUTION FOR THE BASE CASE and then try to extend it further
        // time = M*N
        // space = M
        public int findLength(int[] A, int[] B) {
            if (A == null || B == null) {
                return 0;
            }

            // This can be further optimized by creating array for the smaller one instead of bigger one
            int[] prev = new int[B.length + 1];
            int max = -1;

            for (int i = A.length - 1; i >= 0; i--) {
                int[] next = new int[B.length + 1];
                for (int j = B.length - 1; j >= 0; j--) {

                    if (A[i] == B[j]) { // if chars dont match, keep the sum unchanged as 0
                        next[j] = 1 + prev[j + 1];
                        max = Math.max(next[j], max);
                    }
                }
                prev = next;
            }
            return max == -1 ? 0 : max;
        }


        // without Space optimization byt very readable DP solution
        // DP[i][j] is the solution for first[i:] and second[j:]
        // DP[i][j] = 0 if chars dont match and 1 + DP[i+1][j+1] if chars match
        // time = M*N since we fill each cell once
        // space = M*N for DP matrix
//     public int findLength(int[] A, int[] B) {
//         if (A == null || B == null) {
//             return 0;
//         }

//         int[][] dp = new int[A.length + 1][B.length + 1];

//         int max = -1;

//         for (int i = A.length-1; i >= 0; i--) {

//             for (int j = B.length-1; j>=0; j--) {
//                 if (A[i] == B[j]) {
//                     dp[i][j] = 1 + dp[i+1][j+1];
//                     max = Math.max(dp[i][j], max);
//                 }
//             }
//         }

//         return max == -1? 0 : max;

//     }


        // Totally unoptimal algo that Iw as thinking about earlier:
//     1. Create map of char -> list of indexes
//     2. for each char in other string, check all other indexes of htat char in the first string
        // will be pretty bad since we are travelling all spaces repeatedly without caching results
    }
}

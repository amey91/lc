package javasolutions.dp;

import java.util.Arrays;
// 62. Unique Paths
// #62 https://leetcode.com/problems/unique-paths/
public class UniquePaths {


    // DP where dp[i][j] = dp[i+1][j] + dp[i][j+1]
    // space = M due to optimization
    // time = M*N since we visit all cells
    public int uniquePaths(int m, int n) {

        // TODO we can decide which of N and M is smaller and allocate that here
        int[] prev = new int[m];
        Arrays.fill(prev, 1);

        for (int i = n-2; i>=0; i--) {
            int[] curr = new int[m];
            curr[m-1] = prev[m-1];

            for (int j = m-2; j >=0; j--) {
                curr[j] = curr[j+1] + prev[j];
            }
            prev = curr;
        }

        return prev[0];
    }

//    This solution is M*N space/time. Above solution is M space and M*N time due to DP space optimization
//    class Solution {
//        public int uniquePaths(int m, int n) {
//            // matrix is (m-1)x(n-1)
//            int[][] memoize = new int[m][n];
//            for (int[] ints : memoize) {
//                Arrays.fill(ints, -1);
//            }
//
//            // bottom row
//            Arrays.fill(memoize[memoize.length - 1], 1);
//
//
//            for (int i = m-2; i>=0; i--) {
//                // right column
//                memoize[i][n-1] = 1;
//
//                for (int j=n-2; j >=0; j--) {
//                    memoize[i][j] = memoize[i][j+1] + memoize[i+1][j];
//                }
//            }
//            return memoize[0][0];
//
//
//            // return calculatePaths(0 , 0, m-1, n-1, memoize);
//        }
//
//        private int calculatePaths(int currRow,
//                                   int currColumn,
//                                   int maxRow,
//                                   int maxColumn,
//                                   int[][] memoize) {
//            if (memoize[currRow][currColumn] != -1) {
//                return memoize[currRow][currColumn];
//            }
//            int sum = 0;
//            if (currColumn < maxColumn) {
//                sum += calculatePaths(currRow, currColumn + 1, maxRow, maxColumn, memoize);
//            }
//            if (currRow < maxRow) {
//                sum += calculatePaths(currRow + 1, currColumn, maxRow, maxColumn, memoize);
//            }
//            memoize[currRow][currColumn] = sum;
//            return sum;
//        }
//    }
}

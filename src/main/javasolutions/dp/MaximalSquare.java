package javasolutions.dp;

public class MaximalSquare {
    // 221. Maximal Square
// https://leetcode.com/problems/maximal-square/
    class Solution {

        // uses NM space and NM time
        // approach is to build DP array that considers square for [row][col] only if all 3 of [row+1][col], [row][col+1] and [row+1][col+1] are also set.
        // NOTE: space optimized solution is below but that is easy to derive from this and this is faster too on LC
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }

            int r = matrix.length;
            int c = matrix[0].length;

            int[][] dp = new int[r][c];

            int max = 0;

            // fill last row and col
            for (int row = r - 1; row >= 0; row--) {
                dp[row][c - 1] = matrix[row][c - 1] == '1' ? 1 : 0;
                max = Math.max(max, dp[row][c - 1]);
            }
            // fill last row and col
            for (int col = c - 1; col >= 0; col--) {
                dp[r - 1][col] = matrix[r - 1][col] == '1' ? 1 : 0;
                max = Math.max(max, dp[r - 1][col]);
            }


            for (int row = r - 2; row >= 0; row--) {
                for (int col = c - 2; col >= 0; col--) {
                    if (matrix[row][col] == '1') {

                        // by default, we will at least get 1 area square if it is '1'
                        dp[row][col] = 1;

                        // take minimum value from adjacent and diagonally oppposite dp cells
                        dp[row][col] += Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row + 1][col + 1]);

                        // always update max
                        max = Math.max(max, dp[row][col]);
                    }
                }
            }

            // since we want to return area
            return max * max;

        }


        // this uses M space  and NM time
//     public int maximalSquare_withspaceOptimization_but_somehow_slower(char[][] matrix) {
//         if (matrix == null || matrix.length == 0) {
//             return 0;
//         }

//         int r = matrix.length;
//         int c = matrix[0].length;

//         int[] old = new int[r];
//         int[] curr = new int[r];

//         int max = 0;

//         for (int col = c-1; col >=0; col--) {
//             System.arraycopy(curr, 0, old, 0, curr.length);

//             curr[r-1] = matrix[r-1][col] == '1' ? 1 : 0;
//             max = Math.max(max, curr[r-1]);

//             for (int row = r-2; row >=0; row --) {
//                 if (matrix[row][col] == '0') {
//                     curr[row] = 0;
//                 } else {
//                     curr[row]  = Math.min(curr[row + 1], old[row]);
//                     curr[row]  = Math.min(curr[row], old[row+1]);
//                     curr[row] += 1;
//                     max = Math.max(max, curr[row]);
//                 }
//             }
//         }

//         return max*max;
//     }


    }
}

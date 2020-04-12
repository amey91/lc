package main.java;

// #63 https://leetcode.com/problems/unique-paths-ii/
public class UniquePaths2 {
    class Solution {
        // I have implemented a search that starts with (0,0) instead of (r-1, c-1)
        // because if we start from zero (we essentiall logically flip start with end),
        // we still end up with correct answer since
        // the "water" flow (path that water would take) of the matrix turned on
        // its head remains inverted, but same
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 0;
            }

            int r = obstacleGrid.length;
            int c = obstacleGrid[0].length;

            int[][] memoize = new int[r][c];

            // target
            memoize[0][0] = obstacleGrid[0][0] == 1? 0 : 1;

            // top row
            for (int j=1; j<c; j++) {
                memoize[0][j] = obstacleGrid[0][j] == 1? 0 : memoize[0][j-1];
            }
            // left column
            for (int i = 1; i<r; i++) {
                memoize[i][0] = obstacleGrid[i][0] == 1? 0 : memoize[i-1][0];
            }

            for (int i = 1; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    memoize[i][j] = obstacleGrid[i][j] == 1? 0 :
                            memoize[i-1][j] + memoize[i][j-1];
                }
            }
            return memoize[r-1][c-1];
        }
    }
}

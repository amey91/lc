package javasolutions.arrayprocessing;

public class IslandPerimeter {

    // 463. Island Perimeter
// https://leetcode.com/problems/island-perimeter/
// Easy

    class Solution {

        // traverse the entire matrix and for each cell, add permeter if value in cell is 1. We do not modify the existing matrix
        // time = M*N
        // space = 1
        public int islandPerimeter(int[][] grid) {

            int p = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    // avoid function call for better run time but this is not required strictly speaking
                    if (grid[i][j] == 1) {
                        p += perimeter(grid, i, j);
                    }
                }
            }

            return p;
        }

        private int perimeter(int[][] grid, int i, int j) {
            if (grid[i][j] == 0) {
                return 0;
            }
            int p = 0;
            // left
            if (j == 0 || grid[i][j - 1] == 0) {
                p++;
            }

            // right
            if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                p++;
            }

            // top
            if (i == 0 || grid[i - 1][j] == 0) {
                p++;
            }

            // bottom
            if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                p++;
            }
            return p;
        }
    }
}

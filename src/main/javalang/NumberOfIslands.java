package javalang;

public class NumberOfIslands {
    // 200. Number of Islands
// https://leetcode.com/problems/number-of-islands/

    class Solution {

        // nice approach instead of hardocing directions
        private static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    count += countIsland(grid, row, col);
                }
            }
            return count;
        }

        private int countIsland(char[][] grid, int row, int col) {
            if (grid[row][col] == '0') {
                return 0;
            }

            eraseIsland(grid, row, col);

            return 1;
        }

        private void eraseIsland(char[][] grid, int row, int col) {
            if (row >= grid.length || row < 0) {
                return;
            }
            if (col >= grid[row].length || col < 0) {
                return;
            }

            if (grid[row][col] == '0') {
                return;
            }

            grid[row][col] = '0';
            for (int[] dir : DIRS) {
                eraseIsland(grid, row + dir[0], col + dir[1]);
            }
        }
    }
}

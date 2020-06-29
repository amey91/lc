package javasolutions.bfsdfs;

public class MaxAreaOfIsland {
    // 695. Max Area of Island
// https://leetcode.com/problems/max-area-of-island/
// Medium

    class Solution {

        // Do DFS to erase each island and in DFS function return the area that we just deleted. Keep track of such MaxArea and return it
        // time = M*N
        // space = M*N
        public int maxAreaOfIsland(int[][] grid) {

            if (grid == null || grid.length == 0) {
                return 0;
            }

            int area = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        area = Math.max(area, dfs(grid, i, j));
                    }
                }
            }
            return area;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
                return 0;
            }

            int sum = 1;
            // IMPORTANT: dont forget to mark as visited!!
            grid[i][j] = 0;

            sum += dfs(grid, i + 1, j);
            sum += dfs(grid, i, j + 1);
            sum += dfs(grid, i - 1, j);
            sum += dfs(grid, i, j - 1);

            return sum;

        }
    }
}

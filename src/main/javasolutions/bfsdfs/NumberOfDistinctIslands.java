package javasolutions.bfsdfs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    // 694. Number of Distinct Islands
// https://leetcode.com/problems/number-of-distinct-islands/
// Medium

    class Solution {

        // DFS that erases islands and at the same time, computes a hash like value that contains the configuration with
        // which DFS traverses the island. We store all configurations in a Set to dedup and return size of set
        // space = M*N for matrix traversal
        // time = M*N for matrix traversal
        public int numDistinctIslands(int[][] grid) {
            // do DFS for each island and maintain string set for configuration of seen islands
            Set<String> islandConfigs = new HashSet<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder sb = new StringBuilder();
                        dfs(grid, sb, i, j, "Start");
                        islandConfigs.add(sb.toString());
                    }
                }
            }
            return islandConfigs.size();
        }

        private void dfs(int[][] grid, StringBuilder sb,
                         int i, int j, String currDir) {

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }

            // start of structure
            sb.append(currDir);
            grid[i][j] = 0;

            // can also use smaller identifiers here, but this is for readability
            dfs(grid, sb, i + 1, j, "Bottom");
            dfs(grid, sb, i, j + 1, "Right");
            dfs(grid, sb, i - 1, j, "Top");
            dfs(grid, sb, i, j - 1, "Left");

            // end of structure
            // IMPORTANT: I forgot to add this. If this is not added, then nodes that are reached through other dfs routes will be counted in this route, leading to wrong results
            sb.append(currDir);
        }
    }
}

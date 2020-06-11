package javalang.bfsdfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
    // 934. Shortest Bridge
// https://leetcode.com/problems/shortest-bridge/


    class Solution {

        private final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        // reach the first brigde
        // erase it and populate the first layer
        // bfs till the second bridge and return the level
        // memory = MN
        // space = MN, can probably eliminate the visited array by rebranding each cell, but complexity still stays same because of bfs queue
        public int shortestBridge(int[][] A) {

            boolean[][] visited = new boolean[A.length][A[0].length];
            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < A.length; i++) {
                if (!queue.isEmpty()) {
                    // first island was found
                    break;
                }
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] == 1) {
                        eraseIslandAndGetFirstBFSLayer(A, visited, queue, i, j);
                        break;
                    }
                }
            }

            int level = 1;
            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int[] coordinates = queue.poll();
                    for (int[] dir : DIRS) {
                        int newI = coordinates[0] + dir[0];
                        int newJ = coordinates[1] + dir[1];
                        if (validBound(A, newI, newJ) && !visited[newI][newJ]) {
                            if (A[newI][newJ] == 1) {
                                return level;
                            }
                            visited[newI][newJ] = true;
                            queue.offer(new int[]{newI, newJ});
                        }
                    }
                }
                level++;
            }

            return -1;
        }

        private void eraseIslandAndGetFirstBFSLayer(int[][] A, boolean[][] visited, Queue<int[]> queue, int i, int j) {

            if (!validBound(A, i, j) || visited[i][j]) {
                return;
            }

            visited[i][j] = true;
            queue.add(new int[]{i, j});

            if (A[i][j] == 1) { // dont recurse for 0s
                A[i][j] = 0;
                for (int[] dir : DIRS) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    eraseIslandAndGetFirstBFSLayer(A, visited, queue, newI, newJ);
                }
            }
        }

        private boolean validBound(int[][] A, int i, int j) {
            if (i < 0 || j < 0 || i >= A.length || j >= A[i].length) {
                return false;
            }
            return true;
        }

    }
}

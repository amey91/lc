package javasolutions.topologicalsort;

import java.util.ArrayDeque;
import java.util.Queue;

public class WallsAndGates {

    // 286. Walls and Gates
// https://leetcode.com/problems/walls-and-gates/

    class Solution {

        private final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        private static final int INF = 2147483647;

        class Node {
            int row;
            int col;
            int depth;

            public Node(int i, int j, int d) {
                this.row = i;
                this.col = j;
                this.depth = d;
            }
        }

        // this approach starts from each 0 at once. Imagine a topological sort algorithm that start at multiple nodes at once,
        // this making sure that each fillable spot in the input array is reached in the fastest path since it is topologically sorted from all 0s.
        // space = MN since queue holds all nodes
        // time = MN since we process each cell of the input array once or twice
        public void wallsAndGates(int[][] rooms) {
            // record all zeores
            // start bfs from each 0
            // do till queue is empty
            //      at each stage if node in DIRs is INF, mark it as reached and add it to queue

            if (rooms == null || rooms.length == 0) {
                return;
            }

            // {i, j, depth from 0}
            Queue<Node> queue = new ArrayDeque<>(); // can also be Queue<int[]> but this is faster

            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length; j++) {
                    if (rooms[i][j] == 0) {
                        queue.add(new Node(i, j, 0));
                    }
                }
            }

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                for (int[] dir : DIRS) {

                    int newI = node.row + dir[0];
                    int newJ = node.col + dir[1];
                    int newDepth = node.depth + 1;

                    if (isValidIndex(newI, newJ, rooms)) {
                        rooms[newI][newJ] = newDepth;
                        queue.add(new Node(newI, newJ, newDepth));
                    }
                }
            }
        }

        private boolean isValidIndex(int i, int j, int[][] rooms) {
            // room has not beed visited yet
            return i >= 0 && j >= 0 && i < rooms.length && j < rooms[i].length && rooms[i][j] == INF;
        }
    }
}

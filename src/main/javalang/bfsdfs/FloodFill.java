package javalang.bfsdfs;

public class FloodFill {// 733. Flood Fill
// https://leetcode.com/problems/flood-fill/

    // we do dfs till new cell is valid and new cell has old color
    class Solution {

        private final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            // IMPORTANT: dont forget to check f old and new colors are same before starting
            if (image == null || image.length == 0 || image[sr][sc] == newColor) {
                return image;
            }
            floodFillInternal(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

        private void floodFillInternal(int[][] image, int sr, int sc, int oldColor, int newColor) {
            if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != oldColor) {
                return;
            }

            image[sr][sc] = newColor;
            for (int[] direction : DIRECTIONS) {
                floodFillInternal(image, sr + direction[0], sc + direction[1], oldColor, newColor);
            }
        }
    }

}

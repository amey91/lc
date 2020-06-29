package javasolutions.arrayprocessing;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/
// Medium

    class Solution {

        // Traverse in spiral order and keep passing viable window/coordinates at each stage. Print spiral within the window.
        // Call smaller windows recursively. IMPORTANT: dont forget to check for single row/col matrix where you do not want to print twice
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            if (matrix == null || matrix.length == 0) {
                return result;
            }

            traverseMatrix(result, matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
            return result;
        }

        private void traverseMatrix(List<Integer> result, int[][] mat,
                                    int topRow,
                                    int topCol,
                                    int bottomRow,
                                    int bottomCol) {

            if (topRow == topCol && topCol == bottomRow && bottomRow == bottomCol) {
                result.add(mat[topRow][topRow]); // odd matrix converged
                return;
            }

            if (topRow > bottomRow || topCol > bottomCol) {
                return; // even matrix converged
            }

            if (topRow >= mat.length || topCol >= mat[0].length || bottomRow < 0 || bottomCol < 0) {
                return; // out of bounds
            }

            // left to right
            for (int j = topCol; j <= bottomCol; j++) {
                result.add(mat[topRow][j]);
            }

            // top to bottom
            for (int i = topRow + 1; i <= bottomRow; i++) {
                result.add(mat[i][bottomCol]);
            }

            // right to left
            // IMPORTANT: I forgot to check for this condition
            if (topRow != bottomRow) { // only add to answer if its a different row than left to right
                for (int j = bottomCol - 1; j >= topCol; j--) {
                    result.add(mat[bottomRow][j]);
                }
            }

            // bottom to top
            // IMPORTANT: I forgot to check for this condition
            if (topCol != bottomCol) { // only add to answer if its a different col than top to bottom
                for (int i = bottomRow - 1; i > topRow; i--) {
                    result.add(mat[i][topCol]);
                }
            }

            traverseMatrix(result, mat, topRow + 1, topCol + 1, bottomRow - 1, bottomCol - 1);
        }
    }
}

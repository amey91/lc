package javasolutions;

public class WordSearch {

    // 79. Word Search
// https://leetcode.com/problems/word-search/

// Backtracking

    class Solution {

        private final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        private static final char NULL = '$';

        public boolean exist(char[][] board, String word) {
            if (board == null || word == null || word.length() == 0) {
                return false;
            }

            char[] chars = word.toCharArray();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col] == chars[0]) {

                        // IMP: I had implemeted using seen set but this is not required since at every step we are aware of the
                        // char we are processing, we can just replace the char temporarily
                        // Set<Node> seen = new HashSet<>(chars.length);


                        if (startSearch(board, row, col, chars, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean startSearch(char[][] board, int row, int col, char[] chars, int index) {
            if (index == chars.length) {
                return true;
            }

            // out of bounds
            if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
                return false;
            }
            if (board[row][col] != chars[index]) {
                return false;
            }

            board[row][col] = NULL;
            for (int[] direction : DIRS) {
                if (startSearch(board, row + direction[0], col + direction[1], chars, index + 1)) {
                    return true;
                }
            }
            // backtrack, restore original value
            board[row][col] = chars[index];
            return false;
        }
    }
}

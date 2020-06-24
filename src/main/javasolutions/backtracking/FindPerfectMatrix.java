package javasolutions.backtracking;

import java.util.ArrayDeque;

public class FindPerfectMatrix {
    // find a matrix such that sum of every row, every column and all diagonals sums up to the same number!

    private static final int[][] DIRS = new int[][]{{0,1},{1,0}, {-1,0}, {0,-1}};

//    private static int SIZE = 3;  // 3x3 matrix
    private static int SIZE = 5; // 5x5 matrix

    public static void main(String[] args) {


        int[][] arr = new int[SIZE][SIZE];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1 ;  i <= SIZE * SIZE; i++) {
            deque.offerLast(i);
        }
        // calculate teh target for each row, column and diagonal which is equal parts of the sum of all numbers in matrix
        int target = SIZE * SIZE;
        target = target * (target + 1) / 2 / SIZE;

        System.out.println(new FindPerfectMatrix().populate(arr, new int[]{0,0}, target, deque));

        print2D(arr);

    }

    private boolean populate(int[][] nums, int[] currPair, int target, ArrayDeque<Integer> left) {

        if (currPair == null || left.isEmpty()) {
            return isSumCorrect(nums, target);
        }

        int col = currPair[1];
        int row = currPair[0];

        for (int i = 0; i < left.size(); i++) {
            nums[row][col] = left.pollFirst();

            // trim down the recursion tree/solution space aggressively to not call any more states recursively if the current row sum is not optimal
            if (col == SIZE - 1 && !validateRow(nums, row, target)) {
                // fail early for last column sum
                left.offerLast(nums[row][col]);
                nums[row][col] = 0;
                continue;
            }

            // trim down the recursion tree/solution space aggressively to not call any more states recursively if the current column sum is not optimal
            if (row == SIZE - 1 && !validateColumn(nums, col, target)) {
                // fail early for last row sum
                left.offerLast(nums[row][col]);
                nums[row][col] = 0;
                continue;
            }

            if (populate(nums, getNext(row, col), target, left)) {
                return true;
            }
            left.offerLast(nums[row][col]);
            nums[row][col] = 0;
         }
        return false;
    }

    private int[] getNext(int i, int j) {
        if (i == SIZE-1 && j == SIZE-1) {
            return null;
        }
        if (j == SIZE-1) {
            return new int[]{i+1, 0};
        }
        return new int[]{i, j + 1};
    }

    private boolean validateRow(int[][] nums, int row, int target) {
        int rowSum = 0;
        for (int col = 0; col < SIZE; col++) {
            rowSum += nums[row][col];
        }
        return rowSum == target;
    }

    private boolean validateColumn(int[][] nums, int col, int target) {
        int colSum = 0;
        for (int row = 0; row < SIZE; row++) {
            colSum += nums[row][col];
        }
        return colSum == target;
    }

    private boolean isSumCorrect(int[][] nums, int target) {
        for (int n = 0; n < SIZE; n++) {
            if (!validateRow(nums, n, target) || !validateColumn(nums, n, target)) {
                return false;
            }
        }

        int diagSum = 0;
        for (int i = 0; i < SIZE; i++) {
            diagSum += nums[i][i];
        }
        if (diagSum != target) {
            return false;
        }

        diagSum = 0;
        for (int i = 0; i < SIZE; i++) {
            diagSum += nums[i][SIZE - 1 - i];
        }
        if (diagSum != target) {
            return false;
        }

        return true;

    }

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }

    }
}

package javasolutions.arrayprocessing;

public class NumberOfSquaresInGrid {

    // Problem by Himanshu mama, to count all squares in an M*N matrix
    // time = m^2 * n^2 since for every point I am traversing all other left over points
    // space = 1, did not create a matrix, instead only maintaining int counts.
    public static void main(String[] args) {

        countSquaresInGrid(5, 5);
        countSquaresInGrid(8, 8);
        countSquaresInGrid(100, 100);
    }

    private static void countSquaresInGrid(int ROWS, int COLS) {
        int total = 0;
        for (int row = 1; row <= ROWS; row++) {
            for (int col = 1; col <= COLS; col++) {

                // all squares starting at this position
                total += squares(ROWS, COLS, row, col);
            }
        }

        System.out.println(String.format("Total squares in %d x %d matrix are %d", ROWS, COLS, total));
    }

    /**
     * this counts the actual squares instead of comparing indexes, example:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * then instead of comparing boundaries we compare the square numbers and see if i and j are forming a square
     *
     * This function only goes towards right and down since all other previous squares are already counted.
     */
    private static int squares(int rows, int cols, int row, int col) {
        int sum = 0;
        for (int i = row; i <= rows; i++) {

            for (int j = col; j <= cols; j++) {

                if (i - row == j - col) {
                    sum += 1;
                }

            }
        }
        return sum;
    }
}

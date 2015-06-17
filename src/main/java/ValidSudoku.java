public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] column = new boolean[9][9];        
        boolean[][] row = new boolean[9][9];
        boolean[][] cube = new boolean[9][9];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int val = Character.getNumericValue(board[i][j]);
                // map 1-9 to 0-8
                val--;
                if(row[i][val] || column[j][val] || cube[(i/3)*3 + j/3][val])
                    return false;
                row[i][val] = true;
                column[j][val] = true;
                cube[(i/3)*3 + j/3][val] = true;
            }
        }
        return true;
    }
}
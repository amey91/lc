package leetcode;

import java.util.Arrays;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length==0)
            return;
        if(board.length==1 && board[0].length==1)
            return;
        
        boolean surrounded[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<surrounded.length; i++)
            Arrays.fill(surrounded[i], true);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='X')
                    surrounded[i][j]=false;
            }
        }
        
        // go through rows for edge Os
        checkFirstRow(board, surrounded);
        checkLastRow(board, surrounded);
        // go through columns for edge Os
        checkFirstColumn(board, surrounded);
        checkLastColumn(board, surrounded);
        
        for(int i=0; i<surrounded.length; i++){
            for(int j=0; j<surrounded[0].length; j++){
                if(surrounded[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    
    private void checkFirstColumn(char[][] board, boolean[][] surrounded){
        for(int i=0; i<board.length; i++){
            if(board[i][0]=='O'){
                surrounded[i][0]=false;
                int j = 1;
                while(j<board[0].length && board[i][j]=='O'){
                    surrounded[i][j]=false;
                    checkVertical(board, surrounded, i, j);
                    j++;
                }
            }
        }
    }
    
        
    private void checkLastColumn(char[][] board, boolean[][] surrounded){
        for(int i=0; i<board.length; i++){
            if(board[i][board[0].length-1]=='O'){
                surrounded[i][board[0].length-1]=false;
                int j = board[0].length-2;
                while(j>=0 && board[i][j]=='O'){
                    surrounded[i][j]=false;
                    checkVertical(board, surrounded, i, j);
                    j--;
                }
            }
        }
    }
    
    private void checkFirstRow(char[][] board, boolean[][] surrounded){
       for(int i=0; i<board[0].length; i++){
            if(board[0][i]=='O'){
                surrounded[0][i]=false;
                int j = 1;
                while(j<board.length && board[j][i]=='O'){
                    surrounded[j][i]=false;
                    checkHorizontal(board, surrounded, j, i);
                    j++;
                }
            }
        }
    }
    
    private void checkLastRow(char[][] board, boolean[][] surrounded){
        for(int i=0; i<board[0].length; i++){
            if(board[board.length-1][i]=='O'){
                surrounded[board.length-1][i]=false;
                int j = board.length-2;
                while(j>=0 && board[j][i]=='O'){
                    surrounded[j][i]=false;
                    checkHorizontal(board, surrounded, j, i);
                    j--;
                }
            }
        }
    }

    
    private void checkHorizontal(char[][] board, boolean[][] surrounded, int row, int column){
        int tempColumn = column;
        while(--column>=0 && board[row][column]=='O'){
            if(surrounded[row][column]){
                surrounded[row][column]=false;
                checkVertical(board, surrounded, row, column);
            }
        }
        column=tempColumn;
        while(++column<board.length && board[row][column]=='O'){
            if(surrounded[row][column]){
                surrounded[row][column]=false;
                checkVertical(board, surrounded, row, column);
            }
        }
    }
    
    private void checkVertical(char[][] board, boolean[][] surrounded, int row, int column){
        int tempRow = row;
        while(--row>=0 && board[row][column]=='O'){
            if(surrounded[row][column]){
                surrounded[row][column]=false;
                checkHorizontal(board, surrounded, row, column);
            }
        }
        row=tempRow;
        while(++row<board.length && board[row][column]=='O'){
            if(surrounded[row][column]){
                surrounded[row][column]=false;
                checkHorizontal(board, surrounded, row, column);
            }
        }
    }
}
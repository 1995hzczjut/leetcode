package com.leetcode.dfs;

import org.tensorflow.Session;

/**
 * @author Zhancong Huang
 * @date 10:51 2020/4/15
 */
public class _37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    /**
     * 给定输入情况的格子，若此种状态能填完返回true,反之false
     */
    private boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)){
                        board[i][j] = k;
                        if (solve(board)) return true;
                        //这一步是重点，回顾之前的combination问题，回溯上去一定要重置
                        else board[i][j] = '.';
                    }
                }
                //走到这里代表给定输入的格子，[i,j]填任何数字都不可能完成，返回false
                return false;
            }
        }
        return true;
    }

    private boolean isValid1(char[][] board, int x, int y, char c){
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == c) return false;
            if (board[i][y] == c) return false;
        }
        //确定当前点对应的Box的左上角坐标
        int xx = 3 * (x / 3), yy = 3 * ( y / 3);
        for (int i = xx; i < xx + 3; i++) {
            for (int j = yy; j < yy + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }


    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}

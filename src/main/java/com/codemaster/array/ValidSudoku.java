package com.codemaster.array;

/**
 * leetcode 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/description/
 */
public class ValidSudoku {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];

    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '0' - 1;
                if (line[i][index] || column[j][index] || block[i / 3][j / 3][index]) {
                    return false;
                } else {
                    line[i][index] = column[j][index] = block[i / 3][j / 3][index] = true;
                }
            }
        }
        return true;
    }
}

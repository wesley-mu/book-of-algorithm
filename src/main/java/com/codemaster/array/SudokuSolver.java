package com.codemaster.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 37 解数独
 * https://leetcode.cn/problems/sudoku-solver/description/
 */
public class SudokuSolver {
    private boolean valid = false;
    // 行标识
    boolean[][] line = new boolean[9][9];
    // 列标识
    boolean[][] column = new boolean[9][9];
    // 九宫格标识
    boolean[][][] block = new boolean[3][3][9];
    // 用来存放空白格
    List<int[]> spaces = new ArrayList<>();
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudokuBack(board);
    }
    /**
     * 回溯法
     *
     * @param board
     */
    public void solveSudokuBack(char[][] board) {
        // 遍历数独数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    // 通过char减去'0'的方式将char类型数字转换为int
                    int index = board[i][j] - '0' - 1; // 减1为坐标位置
                    // 该位置是数字x, 需要将行、列以及九宫格相应位置均置为true
                    line[i][index] = column[j][index] = block[i / 3][j / 3][index] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}

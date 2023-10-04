package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _36Valid_Sudoku {

    public static void main(String[] args) {
        Comparable[] n = new Integer[11];

        char[][] board = new char[][]{
              {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
              {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<List<Integer>, Set<Character>> tripleBoard = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tripleBoard.put(Arrays.asList(i, j), new HashSet<>());
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 47) {
                    if (columns.containsKey(i)) {
                        if (columns.get(i).contains(board[i][j]))
                            return false;
                        else columns.get(i).add(board[i][j]);
                    } else columns.computeIfAbsent(i, ch -> new HashSet<>()).add(board[i][j]);
                }
                if (board[j][i] > 47) {
                    if (rows.containsKey(i)) {
                        if (rows.get(i).contains(board[j][i]))
                            return false;
                        else rows.get(i).add(board[j][i]);
                    } else rows.computeIfAbsent(i, ch -> new HashSet<>()).add(board[j][i]);
                }
                    if (tripleBoard.get(Arrays.asList(i / 3, j / 3)).contains(board[i][j])) {
                        return false;
                    } else tripleBoard.get(Arrays.asList(i / 3, j / 3)).add(board[i][j]);
                }
            }

        return true;
    }
}



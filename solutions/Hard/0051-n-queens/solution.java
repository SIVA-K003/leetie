// ──────────────────────────────────────────────────
// Problem  : 51. N-Queens
// Difficulty: Hard
// Tags     : Array, Backtracking, Algorithm X
// Link     : https://leetcode.com/problems/n-queens/
// Runtime  : 1 ms (beats 100%)
// Memory   : 45808000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        backtrack(0, n, board, cols, mainDiag, antiDiag, ans);
        return ans;
    }

    private void backtrack(
            int row,
            int n,
            char[][] board,
            boolean[] cols,
            boolean[] mainDiag,
            boolean[] antiDiag,
            List<List<String>> ans) {
        if (row == n) {
            List<String> config = new ArrayList<>(n);
            for (int r = 0; r < n; r++) {
                config.add(new String(board[r]));
            }
            ans.add(config);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || mainDiag[d1] || antiDiag[d2]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            mainDiag[d1] = true;
            antiDiag[d2] = true;

            backtrack(row + 1, n, board, cols, mainDiag, antiDiag, ans);

            board[row][col] = '.';
            cols[col] = false;
            mainDiag[d1] = false;
            antiDiag[d2] = false;
        }
    }
}
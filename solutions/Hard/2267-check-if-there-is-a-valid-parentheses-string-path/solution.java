// ──────────────────────────────────────────────────
// Problem  : 2267.  Check if There Is a Valid Parentheses String Path
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Matrix, Bracket Sequences
// Link     : https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/
// Runtime  : 5 ms (beats 93%)
// Memory   : 75096000 (beats 68%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Path length must be even to form a valid parentheses string
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        memo = new Boolean[m][n][(m + n) / 2 + 1];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
       
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

       
        if (balance < 0) return false;

       
        int remainingSteps = (m - 1 - r) + (n - 1 - c);
        if (balance > remainingSteps) return false;

      
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Return memoized result if available
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(grid, r + 1, c, balance);
        }

        
        if (!found && c + 1 < n) {
            found = dfs(grid, r, c + 1, balance);
        }

        return memo[r][c][balance] = found;
    }
}
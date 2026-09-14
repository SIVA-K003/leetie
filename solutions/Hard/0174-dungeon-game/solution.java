// ──────────────────────────────────────────────────
// Problem  : 174. Dungeon Game
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Matrix
// Link     : https://leetcode.com/problems/dungeon-game/
// Runtime  : 2 ms (beats 68%)
// Memory   : 45256000 (beats 56%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        
        // Base case: destination room (princess)
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        // Fill the last column (can only move DOWN)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        // Fill the last row (can only move RIGHT)
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        
        // Fill the rest of the DP table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }
        
        return dp[0][0];
    }
}
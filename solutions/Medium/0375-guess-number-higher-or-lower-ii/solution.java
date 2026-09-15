// ──────────────────────────────────────────────────
// Problem  : 375. Guess Number Higher or Lower II
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Minimax, Game Theory
// Link     : https://leetcode.com/problems/guess-number-higher-or-lower-ii/
// Runtime  : 18 ms (beats 80%)
// Memory   : 43244000 (beats 63%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        
        // len is the length of the range [i, j]
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try picking every number x in the range [i, j]
                for (int x = i; x <= j; x++) {
                    int cost = x + Math.max(dp[i][x - 1], dp[x + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[1][n];
    }
}
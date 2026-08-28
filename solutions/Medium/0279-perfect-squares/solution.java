// ──────────────────────────────────────────────────
// Problem  : 279. Perfect Squares
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Breadth-First Search, Knapsack Problem, Complete Knapsack
// Link     : https://leetcode.com/problems/perfect-squares/
// Runtime  : 30 ms (beats 78%)
// Memory   : 44448000 (beats 66%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Maximum possible count is 1 + 1 + ... + 1
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}
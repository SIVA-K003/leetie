// ──────────────────────────────────────────────────
// Problem  : 474. Ones and Zeroes
// Difficulty: Medium
// Tags     : Array, String, Dynamic Programming, Knapsack Problem, 0-1 Knapsack
// Link     : https://leetcode.com/problems/ones-and-zeroes/
// Runtime  : 0 ms (beats 0%)
// Memory   : 40984000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}
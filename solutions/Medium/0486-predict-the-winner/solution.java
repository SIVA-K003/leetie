// ──────────────────────────────────────────────────
// Problem  : 486. Predict the Winner
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Recursion, Minimax, Game Theory, Zero-Sum Game
// Link     : https://leetcode.com/problems/predict-the-winner/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41536000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        
        return dp[0][n - 1] >= 0;
    }
}
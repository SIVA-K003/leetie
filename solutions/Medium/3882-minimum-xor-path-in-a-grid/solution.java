// ──────────────────────────────────────────────────
// Problem  : 3882. Minimum XOR Path in a Grid
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Bit Manipulation, Matrix
// Link     : https://leetcode.com/problems/minimum-xor-path-in-a-grid/
// Runtime  : 755 ms (beats 5%)
// Memory   : 280676000 (beats 7%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        Set<Integer>[][] dp = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        
        
        dp[0][0].add(grid[0][0]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x : dp[i][j]) {
                    
                    if (j + 1 < n) {
                        dp[i][j + 1].add(x ^ grid[i][j + 1]);
                    }
                    
                    if (i + 1 < m) {
                        dp[i + 1][j].add(x ^ grid[i + 1][j]);
                    }
                }
            }
        }
        
        
        int minXor = Integer.MAX_VALUE;
        for (int x : dp[m - 1][n - 1]) {
            minXor = Math.min(minXor, x);
        }
        
        return minXor;
    }
}
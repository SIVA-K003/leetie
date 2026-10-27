// ──────────────────────────────────────────────────
// Problem  : 3963. Create Grid With Exactly One Path
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/create-grid-with-exactly-one-path/
// Runtime  : 2 ms (beats 95%)
// Memory   : 46180000 (beats 82%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        
        // Fill the entire grid with obstacles ('#')
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }
        
        // Path: Move right along the first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        
        // Path: Move down along the last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Convert char[][] to String[]
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}
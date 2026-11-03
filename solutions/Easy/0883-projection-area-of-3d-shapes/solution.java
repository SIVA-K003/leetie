// ──────────────────────────────────────────────────
// Problem  : 883. Projection Area of 3D Shapes
// Difficulty: Easy
// Tags     : Array, Math, Geometry, Matrix
// Link     : https://leetcode.com/problems/projection-area-of-3d-shapes/
// Runtime  : 3 ms (beats 26%)
// Memory   : 45464000 (beats 98%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0;
        int yz = 0;
        int zx = 0;

        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            
            for (int j = 0; j < n; j++) {
                // XY-plane: count cells with at least one cube
                if (grid[i][j] > 0) {
                    xy++;
                }
                
                // Track the maximum height in the current row (ZX-plane)
                maxRow = Math.max(maxRow, grid[i][j]);
                
                // Track the maximum height in the current column (YZ-plane)
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            
            zx += maxRow;
            yz += maxCol;
        }

        return xy + yz + zx;
    }
}
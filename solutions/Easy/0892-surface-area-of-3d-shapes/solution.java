// ──────────────────────────────────────────────────
// Problem  : 892. Surface Area of 3D Shapes
// Difficulty: Easy
// Tags     : Array, Math, Geometry, Matrix
// Link     : https://leetcode.com/problems/surface-area-of-3d-shapes/
// Runtime  : 7 ms (beats 6%)
// Memory   : 45488000 (beats 97%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    // Add top and bottom faces
                    totalArea += 2;

                    // Check all 4 orthogonal directions
                    int up = (i > 0) ? grid[i - 1][j] : 0;
                    int down = (i < n - 1) ? grid[i + 1][j] : 0;
                    int left = (j > 0) ? grid[i][j - 1] : 0;
                    int right = (j < n - 1) ? grid[i][j + 1] : 0;

                    // Add exposed surface area for each side
                    totalArea += Math.max(0, v - up);
                    totalArea += Math.max(0, v - down);
                    totalArea += Math.max(0, v - left);
                    totalArea += Math.max(0, v - right);
                }
            }
        }

        return totalArea;
    }
}
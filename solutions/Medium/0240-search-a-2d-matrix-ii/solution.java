// ──────────────────────────────────────────────────
// Problem  : 240. Search a 2D Matrix II
// Difficulty: Medium
// Tags     : Array, Binary Search, Divide and Conquer, Matrix
// Link     : https://leetcode.com/problems/search-a-2d-matrix-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42776000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;
        
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        
        return false;
      }
}
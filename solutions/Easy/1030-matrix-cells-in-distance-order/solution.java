// ──────────────────────────────────────────────────
// Problem  : 1030. Matrix Cells in Distance Order
// Difficulty: Easy
// Tags     : Array, Math, Geometry, Sorting, Matrix
// Link     : https://leetcode.com/problems/matrix-cells-in-distance-order/
// Runtime  : 12 ms (beats 77%)
// Memory   : 47704000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }
        
        // Sort cells based on their distance from (rCenter, cCenter)
        Arrays.sort(result, (a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return Integer.compare(distA, distB);
        });
        
        return result;
    }
}
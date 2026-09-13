// ──────────────────────────────────────────────────
// Problem  : 4416. Cyclically Shift Rows and Columns
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/cyclically-shift-rows-and-columns/
// Runtime  : 1 ms (beats 100%)
// Memory   : 47304000 (beats 50%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];
        for(int i =0;i<n;i++){
            int k = rowShift[i];
            for(int j =0;j<n;j++){
                int newCol = (j - k + n)%n;
                temp[i][newCol]= grid[i][j];
            }
        }
        int [][] result = new int[n][n];
        for(int j=0;j<n;j++){
            int k = colShift[j];
            for(int i =0;i<n;i++){
                int newRow = (i - k + n)%n;
                result[newRow][j]= temp[i][j];
            }
        }
        return result;
        
    }
}
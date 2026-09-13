// ──────────────────────────────────────────────────
// Problem  : 4416. Cyclically Shift Rows and Columns
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/cyclically-shift-rows-and-columns/
// Runtime  : 1 ms (beats 100%)
// Memory   : 47548000 (beats 0%)
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
2
[[1,2],[3,4]]
[1,0]
[0,1]
3
[[1,2,3],[4,5,6],[7,8,9]]
[1,2,0]
[2,2,1]
[[2,4],[3,1]]
[[7,8,5],[2,3,9],[6,4,1]]
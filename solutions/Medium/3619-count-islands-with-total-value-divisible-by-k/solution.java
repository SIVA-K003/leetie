// ──────────────────────────────────────────────────
// Problem  : 3619. Count Islands With Total Value Divisible by K
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
// Link     : https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/
// Runtime  : 26 ms (beats 35%)
// Memory   : 101800000 (beats 96%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private static final int[] ROW_DIR = {-1, 1, 0, 0};
    private static final int[] COL_DIR = {0, 0, -1, 1};

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int validIslandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find an unvisited cell that is part of land (> 0)
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long islandSum = bfs(grid, visited, i, j, m, n);
                    if (islandSum % k == 0) {
                        validIslandCount++;
                    }
                }
            }
        }

        return validIslandCount;
    }

    private long bfs(int[][] grid, boolean[][] visited, int startRow, int startCol, int m, int n) {
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        long totalSum = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            totalSum += grid[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + ROW_DIR[d];
                int nc = c + COL_DIR[d];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return totalSum;
    }
}
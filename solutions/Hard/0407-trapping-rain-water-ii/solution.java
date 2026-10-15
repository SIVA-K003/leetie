// ──────────────────────────────────────────────────
// Problem  : 407. Trapping Rain Water II
// Difficulty: Hard
// Tags     : Array, Breadth-First Search, Heap (Priority Queue), Matrix
// Link     : https://leetcode.com/problems/trapping-rain-water-ii/
// Runtime  : 1 ms (beats 0%)
// Memory   : 41540000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
        }

        int water = 0;
        int[] dirs = {-1, 0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0];
            int r = cell[1];
            int c = cell[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i + 1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    water += Math.max(0, height - heightMap[nr][nc]);
                    pq.offer(new int[]{Math.max(height, heightMap[nr][nc]), nr, nc});
                }
            }
        }

        return water;
    }
}
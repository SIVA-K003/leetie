// ──────────────────────────────────────────────────
// Problem  : 803. Bricks Falling When Hit
// Difficulty: Hard
// Tags     : Array, Union-Find, Matrix
// Link     : https://leetcode.com/problems/bricks-falling-when-hit/
// Runtime  : 18 ms (beats 72%)
// Memory   : 89940000 (beats 21%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int[] parent;
    private int[] size;

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Mark hits in the grid
        for (int[] hit : hits) {
            int r = hit[0];
            int c = hit[1];
            if (grid[r][c] == 1) {
                grid[r][c] = 2; // Marked as hit
            }
        }

        int totalCells = m * n;
        parent = new int[totalCells + 1];
        size = new int[totalCells + 1];

        for (int i = 0; i <= totalCells; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int roof = totalCells;

        // Step 2: Build initial union-find graph with remaining bricks
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int idx = r * n + c;
                    if (r == 0) {
                        union(idx, roof);
                    }
                    if (r > 0 && grid[r - 1][c] == 1) {
                        union(idx, (r - 1) * n + c);
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        union(idx, r * n + (c - 1));
                    }
                }
            }
        }

        int[] result = new int[hits.length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 3: Process hits in reverse order
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0];
            int c = hits[i][1];

            if (grid[r][c] != 2) {
                result[i] = 0;
                continue;
            }

            grid[r][c] = 1; // Restore brick
            int idx = r * n + c;
            int prevRoofSize = size[find(roof)];

            if (r == 0) {
                union(idx, roof);
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    union(idx, nr * n + nc);
                }
            }

            int currentRoofSize = size[find(roof)];
            if (currentRoofSize > prevRoofSize) {
                result[i] = currentRoofSize - prevRoofSize - 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}
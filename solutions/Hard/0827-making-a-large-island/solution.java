// ──────────────────────────────────────────────────
// Problem  : 827. Making A Large Island
// Difficulty: Hard
// Tags     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
// Link     : https://leetcode.com/problems/making-a-large-island/
// Runtime  : 106 ms (beats 47%)
// Memory   : 153032000 (beats 32%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int maxArea = 0;

        // Step 1: Label each island with a unique ID and calculate its size
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(grid, r, c, islandId);
                    islandSize.put(islandId, size);
                    maxArea = Math.max(maxArea, size);
                    islandId++;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 2: Check each 0 and see what island size we can form by flipping it to 1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighboringIslands = new HashSet<>();
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                            neighboringIslands.add(grid[nr][nc]);
                        }
                    }

                    int currentArea = 1; // Flipping this 0 to 1
                    for (int id : neighboringIslands) {
                        currentArea += islandSize.get(id);
                    }
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = id;
        int size = 1;
        size += dfs(grid, r + 1, c, id);
        size += dfs(grid, r - 1, c, id);
        size += dfs(grid, r, c + 1, id);
        size += dfs(grid, r, c - 1, id);
        return size;
    }
}
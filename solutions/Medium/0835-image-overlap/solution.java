// ──────────────────────────────────────────────────
// Problem  : 835. Image Overlap
// Difficulty: Medium
// Tags     : Array, Matrix
// Link     : https://leetcode.com/problems/image-overlap/
// Runtime  : 196 ms (beats 18%)
// Memory   : 47944000 (beats 9%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        // Collect coordinates of all 1s in both matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) list1.add(new int[]{i, j});
                if (img2[i][j] == 1) list2.add(new int[]{i, j});
            }
        }

        // Count frequencies of shift vectors (r2 - r1, c2 - c1)
        Map<String, Integer> countMap = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];
                String key = dr + "," + dc;
                
                int current = countMap.getOrDefault(key, 0) + 1;
                countMap.put(key, current);
                maxOverlap = Math.max(maxOverlap, current);
            }
        }

        return maxOverlap;
    }
}
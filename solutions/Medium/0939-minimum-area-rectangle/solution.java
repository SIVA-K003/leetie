// ──────────────────────────────────────────────────
// Problem  : 939. Minimum Area Rectangle
// Difficulty: Medium
// Tags     : Array, Hash Table, Math, Geometry, Sorting
// Link     : https://leetcode.com/problems/minimum-area-rectangle/
// Runtime  : 656 ms (beats 16%)
// Memory   : 46532000 (beats 91%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;

class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        int minArea = Integer.MAX_VALUE;

        // Iterate through all pairs of points as potential diagonals
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                // Check if they form a diagonal (not on the same vertical or horizontal line)
                if (x1 != x2 && y1 != y2) {
                    // Check if the other two corners exist
                    if (pointSet.contains(x1 + "," + y2) && pointSet.contains(x2 + "," + y1)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
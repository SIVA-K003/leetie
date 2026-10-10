// ──────────────────────────────────────────────────
// Problem  : 391. Perfect Rectangle
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Geometry, Sweep Line
// Link     : https://leetcode.com/problems/perfect-rectangle/
// Runtime  : 39 ms (beats 61%)
// Memory   : 56112000 (beats 15%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        java.util.HashSet<String> set = new java.util.HashSet<>();
        long totalArea = 0;

        for (int[] rect : rectangles) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);

            totalArea += (long) (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String p1 = rect[0] + " " + rect[1];
            String p2 = rect[0] + " " + rect[3];
            String p3 = rect[2] + " " + rect[1];
            String p4 = rect[2] + " " + rect[3];

            for (String p : new String[]{p1, p2, p3, p4}) {
                if (!set.add(p)) {
                    set.remove(p);
                }
            }
        }

        String c1 = minX + " " + minY;
        String c2 = minX + " " + maxY;
        String c3 = maxX + " " + minY;
        String c4 = maxX + " " + maxY;

        if (set.size() != 4 || !set.contains(c1) || !set.contains(c2) || !set.contains(c3) || !set.contains(c4)) {
            return false;
        }

        return totalArea == (long) (maxX - minX) * (maxY - minY);
    }
}
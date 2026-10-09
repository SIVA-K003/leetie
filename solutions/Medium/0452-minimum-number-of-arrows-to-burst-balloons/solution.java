// ──────────────────────────────────────────────────
// Problem  : 452. Minimum Number of Arrows to Burst Balloons
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Runtime  : 50 ms (beats 97%)
// Memory   : 95864000 (beats 19%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }

        return arrows;
    }
}
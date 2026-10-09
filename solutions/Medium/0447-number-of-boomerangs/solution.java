// ──────────────────────────────────────────────────
// Problem  : 447. Number of Boomerangs
// Difficulty: Medium
// Tags     : Array, Hash Table, Math
// Link     : https://leetcode.com/problems/number-of-boomerangs/
// Runtime  : 134 ms (beats 48%)
// Memory   : 46760000 (beats 73%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int totalBoomerangs = 0;

        for (int[] p1 : points) {
            Map<Integer, Integer> distanceMap = new HashMap<>();
            
            for (int[] p2 : points) {
                if (p1 == p2) continue;

                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int distSquare = dx * dx + dy * dy;

                distanceMap.put(distSquare, distanceMap.getOrDefault(distSquare, 0) + 1);
            }

            for (int count : distanceMap.values()) {
                totalBoomerangs += count * (count - 1);
            }
        }

        return totalBoomerangs;
    }
}
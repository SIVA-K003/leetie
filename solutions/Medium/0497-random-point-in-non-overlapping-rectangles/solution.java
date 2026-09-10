// ──────────────────────────────────────────────────
// Problem  : 497. Random Point in Non-overlapping Rectangles
// Difficulty: Medium
// Tags     : Array, Math, Binary Search, Reservoir Sampling, Prefix Sum, Ordered Set, Randomized
// Link     : https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
// Runtime  : 54 ms (beats 58%)
// Memory   : 53340000 (beats 12%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;
import java.util.TreeMap;

class Solution {
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private int totalPoints;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.totalPoints = 0;
        this.rand = new Random();

        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            // Number of integer points in rectangle i
            int count = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            totalPoints += count;
            // Key represents the upper bound of point index for rect i
            map.put(totalPoints, i);
        }
    }

    public int[] pick() {
        // Pick a random target integer point from 1 to totalPoints
        int target = rand.nextInt(totalPoints) + 1;
        
        // Find which rectangle contains this target point index
        int rectIndex = map.ceilingEntry(target).getValue();
        int[] r = rects[rectIndex];

        // Randomly pick a point within the chosen rectangle
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);

        return new int[]{x, y};
    }
}
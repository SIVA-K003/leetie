// ──────────────────────────────────────────────────
// Problem  : 435. Non-overlapping Intervals
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy, Sorting
// Link     : https://leetcode.com/problems/non-overlapping-intervals/
// Runtime  : 47 ms (beats 61%)
// Memory   : 115316000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int removeCount = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts before the previous one ends, it's an overlap
            if (intervals[i][0] < prevEnd) {
                removeCount++;
            } else {
                // No overlap, update the end time tracker
                prevEnd = intervals[i][1];
            }
        }
        
        return removeCount;
    }
}
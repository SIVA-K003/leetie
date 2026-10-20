// ──────────────────────────────────────────────────
// Problem  : 436. Find Right Interval
// Difficulty: Medium
// Tags     : Array, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-right-interval/
// Runtime  : 16 ms (beats 50%)
// Memory   : 53484000 (beats 40%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // Array to store {start_time, original_index}
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        
        // Sort by start times
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int targetEnd = intervals[i][1];
            
            // Binary search for the smallest start >= targetEnd
            int left = 0, right = n - 1;
            int targetIndex = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= targetEnd) {
                    targetIndex = starts[mid][1]; // Potential right interval found
                    right = mid - 1;              // Look for an even smaller valid start on the left
                } else {
                    left = mid + 1;
                }
            }
            
            result[i] = targetIndex;
        }
        
        return result;
    }
}
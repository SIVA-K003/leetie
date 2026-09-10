// ──────────────────────────────────────────────────
// Problem  : 715. Range Module
// Difficulty: Hard
// Tags     : Design, Segment Tree, Ordered Set
// Link     : https://leetcode.com/problems/range-module/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42560000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.TreeMap;

class RangeModule {
    private TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (left >= right) return;

        // Find the start of potential overlapping intervals
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) >= left) {
            left = start;
            right = Math.max(right, intervals.get(start));
        } else {
            start = intervals.ceilingKey(left);
        }

        // Merge all overlapping or adjacent intervals
        while (start != null && start <= right) {
            right = Math.max(right, intervals.get(start));
            intervals.remove(start);
            start = intervals.ceilingKey(start);
        }

        intervals.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        return start != null && intervals.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if (left >= right) return;

        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) > left) {
            int end = intervals.get(start);
            if (end > right) {
                intervals.put(right, end); // Split into two parts
            }
            intervals.put(start, left);
        }

        start = intervals.ceilingKey(left);
        while (start != null && start < right) {
            int end = intervals.get(start);
            intervals.remove(start);
            if (end > right) {
                intervals.put(right, end);
            }
            start = intervals.ceilingKey(start);
        }
    }
}
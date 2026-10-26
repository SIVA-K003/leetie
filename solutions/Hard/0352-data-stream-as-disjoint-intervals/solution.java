// ──────────────────────────────────────────────────
// Problem  : 352. Data Stream as Disjoint Intervals
// Difficulty: Hard
// Tags     : Hash Table, Binary Search, Union-Find, Design, Data Stream, Ordered Set
// Link     : https://leetcode.com/problems/data-stream-as-disjoint-intervals/
// Runtime  : 25 ms (beats 14%)
// Memory   : 45116000 (beats 77%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.TreeMap;

class SummaryRanges {
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        // Find the interval with the greatest start key <= value
        Integer lo = map.floorKey(value);
        // Find the interval with the smallest start key >= value
        Integer hi = map.ceilingKey(value);
        
        int start = value;
        int end = value;
        
        // Check if `value` is already inside the floor interval
        if (lo != null && map.get(lo) >= value) {
            return;
        }
        
        // Check if we can merge with the high (right) neighbor
        if (hi != null && hi == value + 1) {
            end = map.get(hi);
            map.remove(hi);
        }
        
        // Check if we can merge with the low (left) neighbor
        if (lo != null && map.get(lo) >= value - 1) {
            start = lo;
            end = Math.max(end, map.get(lo));
        }
        
        map.put(start, end);
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (var entry : map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        }
        return res;
    }
}
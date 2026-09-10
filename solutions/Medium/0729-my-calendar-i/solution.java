// ──────────────────────────────────────────────────
// Problem  : 729. My Calendar I
// Difficulty: Medium
// Tags     : Array, Binary Search, Design, Segment Tree, Ordered Set
// Link     : https://leetcode.com/problems/my-calendar-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42768000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.TreeMap;

class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // Find the closest event that starts before or at startTime
        Integer prev = calendar.floorKey(startTime);
        if (prev != null && calendar.get(prev) > startTime) {
            return false; // Overlaps with previous event
        }

        // Find the closest event that starts after startTime
        Integer next = calendar.ceilingKey(startTime);
        if (next != null && next < endTime) {
            return false; // Overlaps with next event
        }

        calendar.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
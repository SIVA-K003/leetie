// ──────────────────────────────────────────────────
// Problem  : 731. My Calendar II
// Difficulty: Medium
// Tags     : Array, Binary Search, Design, Segment Tree, Prefix Sum, Ordered Set
// Link     : https://leetcode.com/problems/my-calendar-ii/
// Runtime  : 45 ms (beats 90%)
// Memory   : 47036000 (beats 87%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        
        for (int[] overlap : overlaps) {
            if (Math.max(startTime, overlap[0]) < Math.min(endTime, overlap[1])) {
                return false; 
            }
        }

       
        for (int[] booking : bookings) {
            int maxStart = Math.max(startTime, booking[0]);
            int minEnd = Math.min(endTime, booking[1]);

            if (maxStart < minEnd) {
                overlaps.add(new int[]{maxStart, minEnd});
            }
        }

        // Step 3: Add the new event to single bookings list
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
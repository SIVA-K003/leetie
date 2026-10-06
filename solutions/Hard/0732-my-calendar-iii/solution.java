// ──────────────────────────────────────────────────
// Problem  : 732. My Calendar III
// Difficulty: Hard
// Tags     : Binary Search, Design, Segment Tree, Prefix Sum, Ordered Set
// Link     : https://leetcode.com/problems/my-calendar-iii/
// Runtime  : 99 ms (beats 60%)
// Memory   : 47592000 (beats 14%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.TreeMap;

class MyCalendarThree {
    private TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        
        delta.put(startTime, delta.getOrDefault(startTime, 0) + 1);
        delta.put(endTime, delta.getOrDefault(endTime, 0) - 1);

        int maxBooking = 0;
        int activeBookings = 0;

       
        for (int count : delta.values()) {
            activeBookings += count;
            maxBooking = Math.max(maxBooking, activeBookings);
        }

        return maxBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
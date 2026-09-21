// ──────────────────────────────────────────────────
// Problem  : 202. Happy Number
// Difficulty: Easy
// Tags     : Hash Table, Math, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/happy-number/
// Runtime  : 1 ms (beats 78%)
// Memory   : 42260000 (beats 79%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
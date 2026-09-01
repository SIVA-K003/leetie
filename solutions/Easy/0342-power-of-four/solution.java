// ──────────────────────────────────────────────────
// Problem  : 342. Power of Four
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Recursion
// Link     : https://leetcode.com/problems/power-of-four/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42628000 (beats 33%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfFour(int n) {
       
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
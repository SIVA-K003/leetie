// ──────────────────────────────────────────────────
// Problem  : 233. Number of Digit One
// Difficulty: Hard
// Tags     : Math, Dynamic Programming, Recursion
// Link     : https://leetcode.com/problems/number-of-digit-one/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41660000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        
        return count;
    }
}
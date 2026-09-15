// ──────────────────────────────────────────────────
// Problem  : 397. Integer Replacement
// Difficulty: Medium
// Tags     : Dynamic Programming, Greedy, Bit Manipulation, Memoization
// Link     : https://leetcode.com/problems/integer-replacement/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41800000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;

        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num == 3 || num % 4 == 1) {
                num--;
            } else {
                num++;
            }
            count++;
        }

        return count;
    }
}
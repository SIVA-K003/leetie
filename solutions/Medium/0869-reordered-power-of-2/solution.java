// ──────────────────────────────────────────────────
// Problem  : 869. Reordered Power of 2
// Difficulty: Medium
// Tags     : Hash Table, Math, Sorting, Counting, Enumeration
// Link     : https://leetcode.com/problems/reordered-power-of-2/
// Runtime  : 2 ms (beats 60%)
// Memory   : 42148000 (beats 79%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] nChars = sortedDigits(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(nChars, sortedDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }
    
    private char[] sortedDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        return chars;
    }
}
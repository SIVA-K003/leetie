// ──────────────────────────────────────────────────
// Problem  : 3498. Reverse Degree of a String
// Difficulty: Easy
// Tags     : String, Simulation
// Link     : https://leetcode.com/problems/reverse-degree-of-a-string/
// Runtime  : 1 ms (beats 100%)
// Memory   : 44080000 (beats 50%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            int reversedAlphabetPos = 'z' - s.charAt(i) + 1;
            int stringIndex = i + 1;
            totalSum += reversedAlphabetPos * stringIndex;
        }
        return totalSum;
    }
}
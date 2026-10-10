// ──────────────────────────────────────────────────
// Problem  : 389. Find the Difference
// Difficulty: Easy
// Tags     : Hash Table, String, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/find-the-difference/
// Runtime  : 2 ms (beats 66%)
// Memory   : 43216000 (beats 36%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        
        // XOR all characters in string s
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }
        
        // XOR all characters in string t
        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }
        
        return result;
    }
}
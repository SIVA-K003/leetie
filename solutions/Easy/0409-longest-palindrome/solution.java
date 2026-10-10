// ──────────────────────────────────────────────────
// Problem  : 409. Longest Palindrome
// Difficulty: Easy
// Tags     : Hash Table, String, Greedy
// Link     : https://leetcode.com/problems/longest-palindrome/
// Runtime  : 2 ms (beats 72%)
// Memory   : 42956000 (beats 82%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int c : count) {
            length += (c / 2) * 2;
            if (c % 2 == 1) {
                hasOdd = true;
            }
        }
        
        if (hasOdd) {
            length += 1;
        }
        
        return length;
    }
}
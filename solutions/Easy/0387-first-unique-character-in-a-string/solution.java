// ──────────────────────────────────────────────────
// Problem  : 387. First Unique Character in a String
// Difficulty: Easy
// Tags     : Hash Table, String, Queue, Counting
// Link     : https://leetcode.com/problems/first-unique-character-in-a-string/
// Runtime  : 6 ms (beats 86%)
// Memory   : 46780000 (beats 85%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstUniqChar(String s) {
        int[] charCounts = new int[26];
        
        
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
       
        for (int i = 0; i < s.length(); i++) {
            if (charCounts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
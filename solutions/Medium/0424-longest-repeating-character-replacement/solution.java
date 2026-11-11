// ──────────────────────────────────────────────────
// Problem  : 424. Longest Repeating Character Replacement
// Difficulty: Medium
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/longest-repeating-character-replacement/
// Runtime  : 7 ms (beats 91%)
// Memory   : 45280000 (beats 99%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            
           
            maxCount = Math.max(maxCount, count[c - 'A']);

            
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
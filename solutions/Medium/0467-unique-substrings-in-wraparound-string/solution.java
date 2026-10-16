// ──────────────────────────────────────────────────
// Problem  : 467. Unique Substrings in Wraparound String
// Difficulty: Medium
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/unique-substrings-in-wraparound-string/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42240000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] count = new int[26];
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                maxLength++;
            } else {
                maxLength = 1;
            }
            int index = s.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLength);
        }
        
        int total = 0;
        for (int c : count) {
            total += c;
        }
        return total;
    }
}
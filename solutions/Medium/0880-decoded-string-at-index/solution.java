// ──────────────────────────────────────────────────
// Problem  : 880. Decoded String at Index
// Difficulty: Medium
// Tags     : String, Stack
// Link     : https://leetcode.com/problems/decoded-string-at-index/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42480000 (beats 78%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String decodeAtIndex(String s, int k) {
        long length = 0;
        int n = s.length();
        
        // Step 1: Find the total length of the decoded string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                length *= (c - '0');
            } else {
                length++;
            }
        }
        
        // Step 2: Work backwards from the end
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            // Handle 1-based indexing modulo wrap-around
            k %= length;
            if (k == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            
            if (Character.isDigit(c)) {
                length /= (c - '0');
            } else {
                length--;
            }
        }
        
        return "";
    }
}
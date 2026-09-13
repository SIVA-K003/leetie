// ──────────────────────────────────────────────────
// Problem  : 151. Reverse Words in a String
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-words-in-a-string/
// Runtime  : 3 ms (beats 99%)
// Memory   : 44128000 (beats 79%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
    
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) break;


            int j = i;

            
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

    
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(s.substring(i + 1, j + 1));
        }

        return sb.toString();
    }
}
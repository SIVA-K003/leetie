// ──────────────────────────────────────────────────
// Problem  : 921. Minimum Add to Make Parentheses Valid
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Bracket Sequences
// Link     : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42816000 (beats 57%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--; 
                } else {
                    close++;
                }
            }
        }

        return open + close;
            }
}
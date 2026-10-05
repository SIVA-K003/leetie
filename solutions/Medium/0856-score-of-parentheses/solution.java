// ──────────────────────────────────────────────────
// Problem  : 856. Score of Parentheses
// Difficulty: Medium
// Tags     : String, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/score-of-parentheses/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43024000 (beats 12%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                // Check if this ')' forms a primitive "()" pair
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth; // Equivalent to 2^depth
                }
            }
        }

        return score;
    }
}
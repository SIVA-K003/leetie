// ──────────────────────────────────────────────────
// Problem  : 1021. Remove Outermost Parentheses
// Difficulty: Easy
// Tags     : String, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/remove-outermost-parentheses/
// Runtime  : 2 ms (beats 100%)
// Memory   : 43380000 (beats 84%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) {
                    result.append(c);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
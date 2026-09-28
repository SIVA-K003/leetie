// ──────────────────────────────────────────────────
// Problem  : 1614. Maximum Nesting Depth of the Parentheses
// Difficulty: Easy
// Tags     : String, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43112000 (beats 16%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}
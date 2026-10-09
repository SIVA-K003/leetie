// ──────────────────────────────────────────────────
// Problem  : 1541. Minimum Insertions to Balance a Parentheses String
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Bracket Sequences
// Link     : https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// Runtime  : 9 ms (beats 87%)
// Memory   : 47440000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; // Tracks unmatched '('
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
            } else {
                // Check if the next character forms a pair '))'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    // Missing a second ')', insert one
                    insertions++;
                }

                // Match with an existing '(' or insert a missing '('
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++; // Needed an extra '(' before these '))'
                }
            }
        }

       
        insertions += openCount * 2;

        return insertions;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 44. Wildcard Matching
// Difficulty: Hard
// Tags     : String, Dynamic Programming, Greedy, Recursion
// Link     : https://leetcode.com/problems/wildcard-matching/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42608000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < s.length()) {
            // Case 1: Characters match or pattern has '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: Pattern has '*' -> Record position for potential backtracking
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++; // Assume '*' matches empty sequence initially
            } 
            // Case 3: Last seen pattern character was '*' -> Backtrack
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx; // Make '*' match one more character in 's'
            } 
            // Case 4: Mismatch and no '*' to backtrack to
            else {
                return false;
            }
        }

        // Check for remaining trailing '*' characters in pattern
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == p.length();
    }
}
// ──────────────────────────────────────────────────
// Problem  : 115. Distinct Subsequences
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/distinct-subsequences/
// Runtime  : 14 ms (beats 93%)
// Memory   : 42740000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[j] stores the number of subsequences matching t[0...j-1]
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: an empty string t can always be formed once

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}
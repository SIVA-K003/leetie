// ──────────────────────────────────────────────────
// Problem  : 2911. Minimum Changes to Make K Semi-palindromes
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming
// Link     : https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/
// Runtime  : 152 ms (beats 73%)
// Memory   : 46632000 (beats 43%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    // Precomputed divisors for lengths up to 200
    private static final List<Integer>[] DIVISORS = new List[201];
    static {
        for (int i = 1; i <= 200; i++) {
            DIVISORS[i] = new ArrayList<>();
            for (int d = 1; d < i; d++) {
                if (i % d == 0) {
                    DIVISORS[i].add(d);
                }
            }
        }
    }

    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Step 1: Precompute the minimum cost to make s[i...j] a semi-palindrome
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int minChanges = Integer.MAX_VALUE;

                for (int d : DIVISORS[len]) {
                    int changes = 0;
                    // Check each of the d groups
                    for (int g = 0; g < d; g++) {
                        // Count mismatches in the palindrome group
                        int left = i + g;
                        int right = i + len - d + g;
                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                            left += d;
                            right -= d;
                        }
                    }
                    minChanges = Math.min(minChanges, changes);
                }
                cost[i][j] = minChanges;
            }
        }

        // Step 2: DP to partition the string into k semi-palindromes
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1000000);
        }
        dp[0][0] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                // We need at least 2 characters for each semi-palindrome part
                for (int p = 2 * (j - 1); p < i - 1; p++) {
                    dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + cost[p][i - 1]);
                }
            }
        }

        return dp[n][k];
    }
}
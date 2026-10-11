// ──────────────────────────────────────────────────
// Problem  : 1735. Count Ways to Make Array With Product
// Difficulty: Hard
// Tags     : Array, Math, Dynamic Programming, Combinatorics, Number Theory, Prime Factorization, Fermat's Little Theorem
// Link     : https://leetcode.com/problems/count-ways-to-make-array-with-product/
// Runtime  : 44 ms (beats 18%)
// Memory   : 51380000 (beats 32%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 15000;
    private static long[][] C = new long[MAX + 15][15];
    private static int[] minPrime = new int[10001];

    static {
        for (int i = 0; i <= MAX + 14; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 14); j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        for (int i = 2; i <= 10000; i++) {
            if (minPrime[i] == 0) {
                for (int j = i; j <= 10000; j += i) {
                    if (minPrime[j] == 0) minPrime[j] = i;
                }
            }
        }
    }

    public int[] waysToFillArray(int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            
            long totalWays = 1;
            while (k > 1) {
                int p = minPrime[k];
                int count = 0;
                while (k % p == 0) {
                    count++;
                    k /= p;
                }
                totalWays = (totalWays * C[count + n - 1][count]) % MOD;
            }
            ans[i] = (int) totalWays;
        }
        return ans;
    }
}
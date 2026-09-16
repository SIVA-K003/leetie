// ──────────────────────────────────────────────────
// Problem  : 1621. Number of Sets of K Non-Overlapping Line Segments
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Combinatorics, Prefix Sum
// Link     : https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
// Runtime  : 1 ms (beats 95%)
// Memory   : 41892000 (beats 98%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int total = n + k - 1;
        int r = 2 * k;

        if (r > total) return 0;

        long num = 1;
        long den = 1;

        for (int i = 1; i <= r; i++) {
            num = (num * (total - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (int) (num * modInverse(den, MOD) % MOD);
    }

    private long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
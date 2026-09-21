// ──────────────────────────────────────────────────
// Problem  : 204. Count Primes
// Difficulty: Medium
// Tags     : Array, Math, Enumeration, Number Theory, Primality Test, Sieve Theory, Prime Number Sieve
// Link     : https://leetcode.com/problems/count-primes/
// Runtime  : 787 ms (beats 19%)
// Memory   : 79272000 (beats 54%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
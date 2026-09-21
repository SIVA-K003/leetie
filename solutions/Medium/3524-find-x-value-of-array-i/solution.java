// ──────────────────────────────────────────────────
// Problem  : 3524. Find X Value of Array I
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/find-x-value-of-array-i/
// Runtime  : 12 ms (beats 92%)
// Memory   : 91692000 (beats 100%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] nextDp = new long[k];
            int rem = num % k;

            
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    nextDp[(r * rem) % k] += dp[r];
                }
            }

           
            nextDp[rem]++;

           
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return result;
    }
}
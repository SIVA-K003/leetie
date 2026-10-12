// ──────────────────────────────────────────────────
// Problem  : 2897. Apply Operations on Array to Maximize Sum of Squares
// Difficulty: Hard
// Tags     : Array, Hash Table, Greedy, Bit Manipulation
// Link     : https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
// Runtime  : 68 ms (beats 11%)
// Memory   : 81628000 (beats 37%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        long[] maxNums = new long[k];
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 32; bit++) {
                if (bitCount[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            maxNums[i] = currentNum;
        }

        long mod = 1_000_000_007;
        long totalSum = 0;
        for (int i = 0; i < k; i++) {
            totalSum = (totalSum + (maxNums[i] * maxNums[i]) % mod) % mod;
        }

        return (int) totalSum;
    }
}
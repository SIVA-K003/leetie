// ──────────────────────────────────────────────────
// Problem  : 446. Arithmetic Slices II - Subsequence
// Difficulty: Hard
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
// Runtime  : 171 ms (beats 46%)
// Memory   : 109252000 (beats 67%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalSlices = 0;
        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int countAtJ = dp[j].getOrDefault(diff, 0);

                totalSlices += countAtJ;

                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + countAtJ + 1);
            }
        }

        return totalSlices;
    }
}
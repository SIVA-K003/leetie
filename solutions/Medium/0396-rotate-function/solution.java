// ──────────────────────────────────────────────────
// Problem  : 396. Rotate Function
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/rotate-function/
// Runtime  : 5 ms (beats 20%)
// Memory   : 91472000 (beats 16%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f0 = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += (long) i * nums[i];
        }

        long maxF = f0;
        long currentF = f0;

        for (int i = 1; i < n; i++) {
            // F(k) = F(k-1) + sum - n * nums[n - i]
            currentF = currentF + sum - (long) n * nums[n - i];
            maxF = Math.max(maxF, currentF);
        }

        return (int) maxF;
    }
}
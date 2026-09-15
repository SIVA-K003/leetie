// ──────────────────────────────────────────────────
// Problem  : 410. Split Array Largest Sum
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Greedy, Prefix Sum
// Link     : https://leetcode.com/problems/split-array-largest-sum/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42968000 (beats 68%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int splitArray(int[] nums, int k) {
        long low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid; // Try finding a smaller valid maximum sum
            } else {
                low = mid + 1; // Increase allowed limit
            }
        }

        return (int) low;
    }

    private boolean canSplit(int[] nums, int k, long maxAllowedSum) {
        int count = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxAllowedSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}
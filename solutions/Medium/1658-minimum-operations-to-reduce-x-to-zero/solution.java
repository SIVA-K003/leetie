// ──────────────────────────────────────────────────
// Problem  : 1658. Minimum Operations to Reduce X to Zero
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// Runtime  : 4 ms (beats 98%)
// Memory   : 102184000 (beats 45%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        
        int target = totalSum - x;

        
        if (target == 0) {
            return nums.length;
        }

        
        if (target < 0) {
            return -1;
        }

        int maxLen = -1;
        int currentSum = 0;
        int left = 0;

        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
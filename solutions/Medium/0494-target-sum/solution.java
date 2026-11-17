// ──────────────────────────────────────────────────
// Problem  : 494. Target Sum
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Knapsack Problem, 0-1 Knapsack
// Link     : https://leetcode.com/problems/target-sum/
// Runtime  : 629 ms (beats 19%)
// Memory   : 42528000 (beats 87%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, 0, target);
    }

    private int backtrack(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = backtrack(nums, index + 1, currentSum + nums[index], target);
        int subtract = backtrack(nums, index + 1, currentSum - nums[index], target);

        return add + subtract;
    }
}
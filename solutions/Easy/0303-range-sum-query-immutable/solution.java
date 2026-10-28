// ──────────────────────────────────────────────────
// Problem  : 303. Range Sum Query - Immutable
// Difficulty: Easy
// Tags     : Array, Design, Prefix Sum
// Link     : https://leetcode.com/problems/range-sum-query-immutable/
// Runtime  : 8 ms (beats 72%)
// Memory   : 47252000 (beats 91%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}


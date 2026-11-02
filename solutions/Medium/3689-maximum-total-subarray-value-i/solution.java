// ──────────────────────────────────────────────────
// Problem  : 3689. Maximum Total Subarray Value I
// Difficulty: Medium
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/maximum-total-subarray-value-i/
// Runtime  : 2 ms (beats 55%)
// Memory   : 61628000 (beats 84%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        long diff = (long) max - min;
        return diff * k;
    }
}
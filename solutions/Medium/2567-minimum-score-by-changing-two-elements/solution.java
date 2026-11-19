// ──────────────────────────────────────────────────
// Problem  : 2567. Minimum Score by Changing Two Elements
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-score-by-changing-two-elements/
// Runtime  : 18 ms (beats 89%)
// Memory   : 59500000 (beats 47%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int changeTwoLargest = nums[n - 3] - nums[0];
        int changeTwoSmallest = nums[n - 1] - nums[2];
        int changeOneEach = nums[n - 2] - nums[1];

        return Math.min(changeTwoLargest, Math.min(changeTwoSmallest, changeOneEach));
    }
}
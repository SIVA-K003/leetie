// ──────────────────────────────────────────────────
// Problem  : 945. Minimum Increment to Make Array Unique
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting, Counting
// Link     : https://leetcode.com/problems/minimum-increment-to-make-array-unique/
// Runtime  : 45 ms (beats 25%)
// Memory   : 79904000 (beats 49%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }
}
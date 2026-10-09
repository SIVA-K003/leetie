// ──────────────────────────────────────────────────
// Problem  : 453. Minimum Moves to Equal Array Elements
// Difficulty: Medium
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42520000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            sum += num;
        }

        return (int) (sum - (long) min * nums.length);
    }
}
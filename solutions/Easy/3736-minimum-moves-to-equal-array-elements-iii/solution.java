// ──────────────────────────────────────────────────
// Problem  : 3736. Minimum Moves to Equal Array Elements III
// Difficulty: Easy
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/
// Runtime  : 1 ms (beats 98%)
// Memory   : 45916000 (beats 84%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int sum = 0;
        
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        
        return (nums.length * max) - sum;
    }
}
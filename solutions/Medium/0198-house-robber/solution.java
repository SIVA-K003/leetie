// ──────────────────────────────────────────────────
// Problem  : 198. House Robber
// Difficulty: Medium
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/house-robber/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42684000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int prev2 = 0; // Max money robbed up to i - 2
        int prev1 = 0; // Max money robbed up to i - 1
        
        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
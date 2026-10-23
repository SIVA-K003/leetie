// ──────────────────────────────────────────────────
// Problem  : 3644. Maximum K to Sort a Permutation
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
// Runtime  : 2 ms (beats 70%)
// Memory   : 110476000 (beats 70%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1; 

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }

        
        if (k == -1) {
            return 0;
        }

        return k;
    }
}
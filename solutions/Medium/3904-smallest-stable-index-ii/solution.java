// ──────────────────────────────────────────────────
// Problem  : 3904. Smallest Stable Index II
// Difficulty: Medium
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/smallest-stable-index-ii/
// Runtime  : 4 ms (beats 89%)
// Memory   : 133432000 (beats 8%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        
        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }
        
        
        int prefMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefMax = Math.max(prefMax, nums[i]);
            if (prefMax - suffMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}
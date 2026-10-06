// ──────────────────────────────────────────────────
// Problem  : 713. Subarray Product Less Than K
// Difficulty: Medium
// Tags     : Array, Binary Search, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/subarray-product-less-than-k/
// Runtime  : 2 ms (beats 100%)
// Memory   : 49036000 (beats 44%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

           
            while (product >= k) {
                product /= nums[left];
                left++;
            }

           
            count += (right - left + 1);
        }

        return count;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 581. Shortest Unsorted Continuous Subarray
// Difficulty: Medium
// Tags     : Array, Two Pointers, Stack, Greedy, Sorting, Monotonic Stack
// Link     : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// Runtime  : 1 ms (beats 86%)
// Memory   : 47292000 (beats 57%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int end = -1;
        int max = nums[0];
        
       
        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }
        
        int start = 0;
        int min = nums[n - 1];
        
      
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            } else {
                min = nums[i];
            }
        }
        
        return end == -1 ? 0 : end - start + 1;
    }
}
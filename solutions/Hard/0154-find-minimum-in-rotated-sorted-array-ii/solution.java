// ──────────────────────────────────────────────────
// Problem  : 154. Find Minimum in Rotated Sorted Array II
// Difficulty: Hard
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42188000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
// ──────────────────────────────────────────────────
// Problem  : 162. Find Peak Element
// Difficulty: Medium
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/find-peak-element/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43604000 (beats 77%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
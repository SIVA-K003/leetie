// ──────────────────────────────────────────────────
// Problem  : 2161. Partition Array According to Given Pivot
// Difficulty: Medium
// Tags     : Array, Two Pointers, Simulation
// Link     : https://leetcode.com/problems/partition-array-according-to-given-pivot/
// Runtime  : 4 ms (beats 100%)
// Memory   : 159656000 (beats 68%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        
        // Two-pass approach to place elements less than and greater than the pivot
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
        }
        
        // Fill all remaining spots with the pivot value
        while (left <= right) {
            result[left++] = pivot;
        }
        
        return result;
    }
}
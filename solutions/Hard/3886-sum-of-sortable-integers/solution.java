// ──────────────────────────────────────────────────
// Problem  : 3886. Sum of Sortable Integers
// Difficulty: Hard
// Tags     : Array, Math, Sorting, Enumeration
// Link     : https://leetcode.com/problems/sum-of-sortable-integers/
// Runtime  : 111 ms (beats 30%)
// Memory   : 75668000 (beats 43%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        
        // Create the globally sorted version of nums
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        int totalSum = 0;
        
        // Iterate over all possible divisors k of n
        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                if (isValid(nums, sortedNums, k, n)) {
                    totalSum += k;
                }
                int pairedDivisor = n / k;
                if (pairedDivisor != k) {
                    if (isValid(nums, sortedNums, pairedDivisor, n)) {
                        totalSum += pairedDivisor;
                    }
                }
            }
        }
        
        return totalSum;
    }
    
    private boolean isValid(int[] nums, int[] sortedNums, int k, int n) {
        for (int i = 0; i < n; i += k) {
            if (!isRotatedSortedChunk(nums, i, sortedNums, i, k)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isRotatedSortedChunk(int[] nums, int startNums, int[] sortedNums, int startSorted, int k) {
        // Find the drop point (if any) where nums[startNums + j] > nums[startNums + j + 1]
        int dropCount = 0;
        int dropIndex = -1;
        
        for (int j = 0; j < k; j++) {
            int nextVal = nums[startNums + (j + 1) % k];
            int currVal = nums[startNums + j];
            if (currVal > nextVal) {
                dropCount++;
                dropIndex = j;
            }
        }
        
        // A cyclic rotation of a sorted array can have at most 1 drop point
        if (dropCount > 1) {
            return false;
        }
        
        // If it's completely sorted (0 drops), just verify it matches the sorted chunk multiset
        // Or if there is 1 drop, verify that the rotated elements match sortedNums segment
        int offset = (dropCount == 0) ? 0 : (dropIndex + 1);
        
        for (int j = 0; j < k; j++) {
            if (nums[startNums + (offset + j) % k] != sortedNums[startSorted + j]) {
                return false;
            }
        }
        
        return true;
    }
}
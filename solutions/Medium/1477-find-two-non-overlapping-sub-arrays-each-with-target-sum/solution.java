// ──────────────────────────────────────────────────
// Problem  : 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Dynamic Programming, Sliding Window
// Link     : https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// Runtime  : 6 ms (beats 99%)
// Memory   : 90952000 (beats 71%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int minSumOfLengths = Integer.MAX_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink window if sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            
            // Found a valid sub-array with sum equal to target
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // If there's a valid non-overlapping sub-array before `left`
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minSumOfLengths = Math.min(minSumOfLengths, currentLen + minLen[left - 1]);
                }
                
                // Update min length seen so far up to current `right`
                minSoFar = Math.min(minSoFar, currentLen);
            }
            
            // Store the overall minimum length found up to `right`
            minLen[right] = minSoFar;
        }
        
        return minSumOfLengths == Integer.MAX_VALUE ? -1 : minSumOfLengths;
    }
}
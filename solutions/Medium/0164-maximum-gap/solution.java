// ──────────────────────────────────────────────────
// Problem  : 164. Maximum Gap
// Difficulty: Medium
// Tags     : Array, Sorting, Bucket Sort, Radix Sort, Pigeonhole Principle
// Link     : https://leetcode.com/problems/maximum-gap/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41804000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        // If all elements in the array are identical
        if (minVal == maxVal) {
            return 0;
        }

        // Calculate bucket size and count according to Pigeonhole Principle
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        int[] minBucket = new int[bucketCount];
        int[] maxBucket = new int[bucketCount];
        
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        // Put elements into buckets
        for (int num : nums) {
            int bucketIdx = (num - minVal) / bucketSize;
            minBucket[bucketIdx] = Math.min(minBucket[bucketIdx], num);
            maxBucket[bucketIdx] = Math.max(maxBucket[bucketIdx], num);
        }

        // Find maximum gap between consecutive non-empty buckets
        int maxGap = 0;
        int previousMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            // Skip empty buckets
            if (minBucket[i] == Integer.MAX_VALUE) {
                continue;
            }

            maxGap = Math.max(maxGap, minBucket[i] - previousMax);
            previousMax = maxBucket[i];
        }

        return maxGap;
    }
}
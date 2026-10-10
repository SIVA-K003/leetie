// ──────────────────────────────────────────────────
// Problem  : 2333. Minimum Sum of Squared Difference
// Difficulty: Medium
// Tags     : Array, Binary Search, Greedy, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/minimum-sum-of-squared-difference/
// Runtime  : 9 ms (beats 84%)
// Memory   : 119784000 (beats 30%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long totalK = k1 + k2;
        long maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        int[] count = new int[(int) maxDiff + 2];
        for (int d : diff) {
            count[d]++;
        }

        for (int d = (int) maxDiff; d > 0 && totalK > 0; d--) {
            if (count[d] == 0) continue;
            long take = Math.min(totalK, count[d]);
            count[d] -= take;
            count[d - 1] += take;
            totalK -= take;
        }

        long result = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                result += (long) count[d] * d * d;
            }
        }

        return result;
    }
}
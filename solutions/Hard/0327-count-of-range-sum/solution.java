// ──────────────────────────────────────────────────
// Problem  : 327. Count of Range Sum
// Difficulty: Hard
// Tags     : Array, Binary Search, Divide and Conquer, Binary Indexed Tree, Segment Tree, Merge Sort, Ordered Set, Treap
// Link     : https://leetcode.com/problems/count-of-range-sum/
// Runtime  : 55 ms (beats 91%)
// Memory   : 80236000 (beats 78%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return countWithMergeSort(prefix, 0, n + 1, lower, upper);
    }

    private int countWithMergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = countWithMergeSort(prefix, left, mid, lower, upper)
                  + countWithMergeSort(prefix, mid, right, lower, upper);

        // Two-pointer counting step
        int j = mid, k = mid;
        for (int i = left; i < mid; i++) {
            while (k < right && prefix[k] - prefix[i] < lower) {
                k++;
            }
            while (j < right && prefix[j] - prefix[i] <= upper) {
                j++;
            }
            count += (j - k);
        }

        // Standard merge step to keep the array sorted
        long[] sorted = new long[right - left];
        int l = left, r = mid, idx = 0;
        while (l < mid && r < right) {
            if (prefix[l] <= prefix[r]) {
                sorted[idx++] = prefix[l++];
            } else {
                sorted[idx++] = prefix[r++];
            }
        }
        while (l < mid) sorted[idx++] = prefix[l++];
        while (r < right) sorted[idx++] = prefix[r++];

        System.arraycopy(sorted, 0, prefix, left, sorted.length);

        return count;
    }
}
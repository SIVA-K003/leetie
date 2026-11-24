// ──────────────────────────────────────────────────
// Problem  : 321. Create Maximum Number
// Difficulty: Hard
// Tags     : Array, Two Pointers, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/create-maximum-number/
// Runtime  : 7 ms (beats 88%)
// Memory   : 45908000 (beats 89%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] best = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for (int a = start; a <= end; a++) {
            int b = k - a;
            int[] sub1 = maxSubsequence(nums1, a);
            int[] sub2 = maxSubsequence(nums2, b);
            int[] candidate = merge(sub1, sub2, k);

            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }

        return best;
    }

    private int[] maxSubsequence(int[] nums, int len) {
        int[] stack = new int[len];
        int top = -1;
        int drop = nums.length - len;

        for (int num : nums) {
            while (top >= 0 && drop > 0 && stack[top] < num) {
                top--;
                drop--;
            }
            if (top + 1 < len) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] a, int[] b, int k) {
        int[] merged = new int[k];
        int i = 0, j = 0, idx = 0;

        while (idx < k) {
            if (greater(a, i, b, j)) {
                merged[idx++] = a[i++];
            } else {
                merged[idx++] = b[j++];
            }
        }

        return merged;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}
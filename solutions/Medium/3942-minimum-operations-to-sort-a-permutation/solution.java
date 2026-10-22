// ──────────────────────────────────────────────────
// Problem  : 3942. Minimum Operations to Sort a Permutation
// Difficulty: Medium
// Tags     : Array
// Link     : https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
// Runtime  : 4 ms (beats 72%)
// Memory   : 94192000 (beats 97%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {

    public int minOperations(int[] nums) {
        final int s = nums.length;
        if (s == 1) {
            return 0;
        }

        int start = 0;
        while (nums[start] != 0) {
            start++;
        }

        boolean a = true;
        boolean d = true;

        for (int i = 1; i < s; i++) {
            final int value = nums[(start + i) % s];

            if (value != i) {
                a = false;
            }
            if (value != s - i) {
                d = false;
            }

            if (!a && !d) {
                return -1;
            }
        }

        if (a) {
            return Math.min(start, s - start + 2);
        }

        return Math.min(s - start, start + 2);
    }
}
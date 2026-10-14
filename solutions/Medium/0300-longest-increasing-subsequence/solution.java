// ──────────────────────────────────────────────────
// Problem  : 300. Longest Increasing Subsequence
// Difficulty: Medium
// Tags     : Array, Binary Search, Dynamic Programming, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/longest-increasing-subsequence/
// Runtime  : 3 ms (beats 96%)
// Memory   : 45524000 (beats 99%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 330. Patching Array
// Difficulty: Hard
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/patching-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45276000 (beats 62%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minPatches(int[] nums, long n) {
        long miss = 1;
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
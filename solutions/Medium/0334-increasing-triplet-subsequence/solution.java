// ──────────────────────────────────────────────────
// Problem  : 334. Increasing Triplet Subsequence
// Difficulty: Medium
// Tags     : Array, Greedy, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/increasing-triplet-subsequence/
// Runtime  : 2 ms (beats 99%)
// Memory   : 122420000 (beats 76%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
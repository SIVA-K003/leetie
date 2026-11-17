// ──────────────────────────────────────────────────
// Problem  : 491. Non-decreasing Subsequences
// Difficulty: Medium
// Tags     : Array, Hash Table, Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/non-decreasing-subsequences/
// Runtime  : 5 ms (beats 98%)
// Memory   : 51960000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> current, List<List<Integer>> result) {
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }

        boolean[] usedAtThisLevel = new boolean[201];

        for (int i = startIndex; i < nums.length; i++) {
            int val = nums[i];
            
            if (!current.isEmpty() && val < current.get(current.size() - 1)) {
                continue;
            }
            if (usedAtThisLevel[val + 100]) {
                continue;
            }

            usedAtThisLevel[val + 100] = true;
            current.add(val);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
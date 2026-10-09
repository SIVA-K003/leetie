// ──────────────────────────────────────────────────
// Problem  : 448. Find All Numbers Disappeared in an Array
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Runtime  : 6 ms (beats 84%)
// Memory   : 67228000 (beats 55%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
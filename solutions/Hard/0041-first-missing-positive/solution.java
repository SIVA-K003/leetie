// ──────────────────────────────────────────────────
// Problem  : 41. First Missing Positive
// Difficulty: Hard
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/first-missing-positive/
// Runtime  : 1 ms (beats 100%)
// Memory   : 70944000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        
        return n + 1;
    }
}
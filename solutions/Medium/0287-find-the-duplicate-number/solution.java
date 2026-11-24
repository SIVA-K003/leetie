// ──────────────────────────────────────────────────
// Problem  : 287. Find the Duplicate Number
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Bit Manipulation, Pigeonhole Principle, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/find-the-duplicate-number/
// Runtime  : 4 ms (beats 93%)
// Memory   : 82372000 (beats 72%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findDuplicate(int[] nums) {
      
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

       
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
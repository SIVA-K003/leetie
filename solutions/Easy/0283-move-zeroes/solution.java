// ──────────────────────────────────────────────────
// Problem  : 283. Move Zeroes
// Difficulty: Easy
// Tags     : Array, Two Pointers
// Link     : https://leetcode.com/problems/move-zeroes/
// Runtime  : 2 ms (beats 95%)
// Memory   : 46892000 (beats 98%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;

       
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }

       
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }
}
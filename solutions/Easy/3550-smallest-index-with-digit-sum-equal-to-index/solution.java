// ──────────────────────────────────────────────────
// Problem  : 3550. Smallest Index With Digit Sum Equal to Index
// Difficulty: Easy
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
// Runtime  : 1 ms (beats 100%)
// Memory   : 45440000 (beats 78%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (getDigitSum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
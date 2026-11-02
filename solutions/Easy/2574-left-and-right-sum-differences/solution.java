// ──────────────────────────────────────────────────
// Problem  : 2574. Left and Right Sum Differences
// Difficulty: Easy
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/left-and-right-sum-differences/
// Runtime  : 2 ms (beats 99%)
// Memory   : 45608000 (beats 99%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        int[] answer = new int[n];
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        
        return answer;
    }
}
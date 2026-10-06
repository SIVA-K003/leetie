// ──────────────────────────────────────────────────
// Problem  : 689. Maximum Sum of 3 Non-Overlapping Subarrays
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
// Runtime  : 3 ms (beats 99%)
// Memory   : 49188000 (beats 43%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        
       
        int[] sum = new int[m];
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (i >= k) {
                currentSum -= nums[i - k];
            }
            if (i >= k - 1) {
                sum[i - k + 1] = currentSum;
            }
        }
        
        
        int[] left = new int[m];
        int bestLeft = 0;
        for (int i = 0; i < m; i++) {
            if (sum[i] > sum[bestLeft]) {
                bestLeft = i;
            }
            left[i] = bestLeft;
        }
        
        
        int[] right = new int[m];
        int bestRight = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            
            if (sum[i] >= sum[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }
        
        
        int[] result = new int[]{-1, -1, -1};
        int maxSum = -1;
        
        for (int j = k; j < m - k; j++) {
            int l = left[j - k];
            int r = right[j + k];
            int totalSum = sum[l] + sum[j] + sum[r];
            
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = l;
                result[1] = j;
                result[2] = r;
            }
        }
        
        return result;
    }
}
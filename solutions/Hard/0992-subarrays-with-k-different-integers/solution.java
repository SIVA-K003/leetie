// ──────────────────────────────────────────────────
// Problem  : 992. Subarrays with K Different Integers
// Difficulty: Hard
// Tags     : Array, Hash Table, Sliding Window, Counting
// Link     : https://leetcode.com/problems/subarrays-with-k-different-integers/
// Runtime  : 5 ms (beats 99%)
// Memory   : 49052000 (beats 90%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int[] freq = new int[nums.length + 1];
        int distinct = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;
            
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            
            count += right - left + 1;
        }
        
        return count;
    }
}
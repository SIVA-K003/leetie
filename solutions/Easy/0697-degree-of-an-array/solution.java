// ──────────────────────────────────────────────────
// Problem  : 697. Degree of an Array
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/degree-of-an-array/
// Runtime  : 9 ms (beats 97%)
// Memory   : 49268000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int MAX_VAL = 50000;
        int[] count = new int[MAX_VAL];
        int[] first = new int[MAX_VAL];
        int[] last = new int[MAX_VAL];
        
        // Fill first index array with -1 to track unvisited numbers
        Arrays.fill(first, -1);
        
        int degree = 0;
        
        // Single Pass: Calculate counts, first index, and last index
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            
            if (first[x] == -1) {
                first[x] = i;
            }
            last[x] = i;
            
            count[x]++;
            degree = Math.max(degree, count[x]);
        }
        
        int minLen = nums.length;
        
        // Find the minimum distance for elements matching the max degree
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (count[x] == degree) {
                minLen = Math.min(minLen, last[x] - first[x] + 1);
            }
        }
        
        return minLen;
    }
}
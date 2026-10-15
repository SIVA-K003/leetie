// ──────────────────────────────────────────────────
// Problem  : 2913. Subarrays Distinct Element Sum of Squares I
// Difficulty: Easy
// Tags     : Array, Hash Table, Binary Indexed Tree, Segment Tree
// Link     : https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
// Runtime  : 10 ms (beats 27%)
// Memory   : 46628000 (beats 76%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        
        // Generate all possible subarrays
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctElements = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                int count = distinctElements.size();
                totalSum += count * count; // Add square of the distinct count
            }
        }
        
        return totalSum;
    }
}
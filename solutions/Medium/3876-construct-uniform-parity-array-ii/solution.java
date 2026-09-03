// ──────────────────────────────────────────────────
// Problem  : 3876. Construct Uniform Parity Array II
// Difficulty: Medium
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/construct-uniform-parity-array-ii/
// Runtime  : 5 ms (beats 83%)
// Memory   : 121428000 (beats 81%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        int oddCount = 0;
        
        for (int x : nums1) {
            if (x < minVal) {
                minVal = x;
            }
            if (x % 2 != 0) {
                oddCount++;
            }
        }
        
        // If all elements are already even or all odd, return true
        if (oddCount == 0 || oddCount == nums1.length) {
            return true;
        }
        
        // If the smallest element is odd, we can make all elements odd
        return minVal % 2 != 0;
    }
}
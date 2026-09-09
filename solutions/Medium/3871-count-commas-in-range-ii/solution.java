// ──────────────────────────────────────────────────
// Problem  : 3871. Count Commas in Range II
// Difficulty: Medium
// Tags     : Math
// Link     : https://leetcode.com/problems/count-commas-in-range-ii/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42584000 (beats 71%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1000;
        
        while (n >= start) {
            ans += (n - start + 1);
            
            if (start > Long.MAX_VALUE / 1000) break; 
            start *= 1000;
        }
        
        return ans;
    }
}
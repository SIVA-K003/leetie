// ──────────────────────────────────────────────────
// Problem  : 1010. Pairs of Songs With Total Durations Divisible by 60
// Difficulty: Medium
// Tags     : Array, Hash Table, Counting
// Link     : https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// Runtime  : 3 ms (beats 90%)
// Memory   : 49320000 (beats 97%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int ans = 0;
        
        for (int t : time) {
            int remainder = t % 60;
            int target = (60 - remainder) % 60;
            ans += count[target];
            count[remainder]++;
        }
        
        return ans;
    }
}
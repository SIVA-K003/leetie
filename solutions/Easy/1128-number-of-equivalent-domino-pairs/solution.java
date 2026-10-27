// ──────────────────────────────────────────────────
// Problem  : 1128. Number of Equivalent Domino Pairs
// Difficulty: Easy
// Tags     : Array, Hash Table, Counting
// Link     : https://leetcode.com/problems/number-of-equivalent-domino-pairs/
// Runtime  : 4 ms (beats 80%)
// Memory   : 55092000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int ans = 0;
        
        for (int[] d : dominoes) {
            int min = Math.min(d[0], d[1]);
            int max = Math.max(d[0], d[1]);
            int val = min * 10 + max;
            
            ans += count[val];
            count[val]++;
        }
        
        return ans;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 940. Distinct Subsequences II
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/distinct-subsequences-ii/
// Runtime  : 6 ms (beats 44%)
// Memory   : 42700000 (beats 100%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endsWith = new long[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
           
            long total = 1;
            for (int i = 0; i < 26; i++) {
                total = (total + endsWith[i]) % MOD;
            }
            
           
            endsWith[idx] = total;
        }
        
       
        long result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + endsWith[i]) % MOD;
        }
        
        return (int) result;
    }
}
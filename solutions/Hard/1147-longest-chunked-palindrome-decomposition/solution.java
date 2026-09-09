// ──────────────────────────────────────────────────
// Problem  : 1147. Longest Chunked Palindrome Decomposition
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming, Greedy, Rolling Hash, Hash Function
// Link     : https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
// Runtime  : 17 ms (beats 6%)
// Memory   : 52336000 (beats 8%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        int count = 0;
        
        String left = "";
        String right = "";
        
        for (int i = 0; i < n; i++) {
            left = left + text.charAt(i);
            right = text.charAt(n - 1 - i) + right;
            
          
            if (left.equals(right)) {
                count++;
                left = "";
                right = "";
            }
        }
        
        return count;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 3863. Minimum Operations to Sort a String
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/minimum-operations-to-sort-a-string/
// Runtime  : 18 ms (beats 85%)
// Memory   : 47536000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        
        if (n == 2) return -1;
        
        char minChar = s.charAt(0);
        char maxChar = s.charAt(0);
        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }
        
        
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // Check for 3 operations condition
        boolean hasMinInPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                hasMinInPrefix = true;
                //break;
            }
        }
        
        boolean hasMaxInSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                hasMaxInSuffix = true;
                break;
            }
        }
        
        if (!hasMinInPrefix && !hasMaxInSuffix) {
            return 3;
        }
        
        return 2;
    }
}
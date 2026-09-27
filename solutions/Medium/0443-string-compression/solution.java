// ──────────────────────────────────────────────────
// Problem  : 443. String Compression
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/string-compression/
// Runtime  : 1 ms (beats 100%)
// Memory   : 45680000 (beats 20%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int i = 0;
        
        while (i < chars.length) {
            int j = i;
            
           
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            
            int count = j - i;
            
            
            chars[write++] = chars[i];
            
           
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
            
           
            i = j;
        }
        
        return write;
    }
}
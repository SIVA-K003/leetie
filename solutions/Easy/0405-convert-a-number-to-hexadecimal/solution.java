// ──────────────────────────────────────────────────
// Problem  : 405. Convert a Number to Hexadecimal
// Difficulty: Easy
// Tags     : Math, String, Bit Manipulation
// Link     : https://leetcode.com/problems/convert-a-number-to-hexadecimal/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42464000 (beats 80%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            
            int digit = num & 15;
            sb.append(hexChars[digit]);
            
            
            num >>>= 4;
        }
        
        
        return sb.reverse().toString();
    }
}
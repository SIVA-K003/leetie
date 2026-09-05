// ──────────────────────────────────────────────────
// Problem  : 258. Add Digits
// Difficulty: Easy
// Tags     : Math, Simulation, Number Theory
// Link     : https://leetcode.com/problems/add-digits/
// Runtime  : 1 ms (beats 98%)
// Memory   : 42264000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;  
                num /= 10;      
            }
            num = sum;         
        }
        return num;
    }
}
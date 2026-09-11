// ──────────────────────────────────────────────────
// Problem  : 3483. Unique 3-Digit Even Numbers
// Difficulty: Easy
// Tags     : Array, Hash Table, Recursion, Enumeration
// Link     : https://leetcode.com/problems/unique-3-digit-even-numbers/
// Runtime  : 10 ms (beats 24%)
// Memory   : 46716000 (beats 17%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        
        int validCount = 0;
        
        
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;
            
            int[] tempCount = new int[10];
            tempCount[d1]++;
            tempCount[d2]++;
            tempCount[d3]++;
            
            
            if (tempCount[d1] <= count[d1] && 
                tempCount[d2] <= count[d2] && 
                tempCount[d3] <= count[d3]) {
                validCount++;
            }
        }
        
        return validCount;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 3723. Maximize Sum of Squares of Digits
// Difficulty: Medium
// Tags     : Math, Greedy
// Link     : https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
// Runtime  : 130 ms (beats 21%)
// Memory   : 47304000 (beats 99%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum || sum < 1) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
        }
        
        return sb.toString();
    }
}
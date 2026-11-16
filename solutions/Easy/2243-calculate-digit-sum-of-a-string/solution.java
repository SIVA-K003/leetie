// ──────────────────────────────────────────────────
// Problem  : 2243. Calculate Digit Sum of a String
// Difficulty: Easy
// Tags     : String, Simulation
// Link     : https://leetcode.com/problems/calculate-digit-sum-of-a-string/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42292000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                int end = Math.min(i + k, s.length());
                for (int j = i; j < end; j++) {
                    sum += s.charAt(j) - '0';
                }
                newS.append(sum);
            }
            s = newS.toString();
        }
        return s;
    }
}
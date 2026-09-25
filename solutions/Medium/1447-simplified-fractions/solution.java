// ──────────────────────────────────────────────────
// Problem  : 1447. Simplified Fractions
// Difficulty: Medium
// Tags     : Math, String, Number Theory, Euclidean Algorithm, Greatest Common Divisor
// Link     : https://leetcode.com/problems/simplified-fractions/
// Runtime  : 18 ms (beats 36%)
// Memory   : 53156000 (beats 41%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        
        for (int denominator = 2; denominator <= n; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    result.add(numerator + "/" + denominator);
                }
            }
        }
        
        return result;
    }
    
    // Euclidean algorithm to find the Greatest Common Divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
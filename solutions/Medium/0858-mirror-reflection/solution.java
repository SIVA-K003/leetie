// ──────────────────────────────────────────────────
// Problem  : 858. Mirror Reflection
// Difficulty: Medium
// Tags     : Math, Geometry, Number Theory, Least Common Multiple, Greatest Common Divisor
// Link     : https://leetcode.com/problems/mirror-reflection/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42244000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int mirrorReflection(int p, int q) {
        // Reduce p and q by removing their common factor of 2
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }

        if (p % 2 == 0) {
            return 2; 
        } else if (q % 2 == 0) {
            return 0; 
        } else {
            return 1; 
        }
    }
}
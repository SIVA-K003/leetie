// ──────────────────────────────────────────────────
// Problem  : 3783. Mirror Distance of an Integer
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/mirror-distance-of-an-integer/
// Runtime  : 1 ms (beats 100%)
// Memory   : 42876000 (beats 10%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int temp = n;
        
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        
        return Math.abs(n - rev);
    }
}
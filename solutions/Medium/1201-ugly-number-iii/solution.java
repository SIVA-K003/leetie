// ──────────────────────────────────────────────────
// Problem  : 1201. Ugly Number III
// Difficulty: Medium
// Tags     : Math, Binary Search, Combinatorics, Number Theory, Least Common Multiple, Euclidean Algorithm, Greatest Common Divisor, Inclusion-Exclusion Principle
// Link     : https://leetcode.com/problems/ugly-number-iii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41976000 (beats 77%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = 2000000000L;
        
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, bc);
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / a + mid / b + mid / c 
                       - mid / ab - mid / bc - mid / ac 
                       + mid / abc;
            
            if (count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return (int) low;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
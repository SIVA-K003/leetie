// ──────────────────────────────────────────────────
// Problem  : 593. Valid Square
// Difficulty: Medium
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/valid-square/
// Runtime  : 1 ms (beats 94%)
// Memory   : 43312000 (beats 63%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        
        
        int d1 = distSq(p1, p2);
        int d2 = distSq(p1, p3);
        int d3 = distSq(p1, p4);
        int d4 = distSq(p2, p3);
        int d5 = distSq(p2, p4);
        int d6 = distSq(p3, p4);
        
        
        set.add(d1);
        set.add(d2);
        set.add(d3);
        set.add(d4);
        set.add(d5);
        set.add(d6);
        
       
        return !set.contains(0) && set.size() == 2;
    }
    
    private int distSq(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
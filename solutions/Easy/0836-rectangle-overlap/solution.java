// ──────────────────────────────────────────────────
// Problem  : 836. Rectangle Overlap
// Difficulty: Easy
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/rectangle-overlap/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42996000 (beats 5%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        boolean xOverlap = Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]);
        boolean yOverlap = Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
        
        return xOverlap && yOverlap;
    }
}
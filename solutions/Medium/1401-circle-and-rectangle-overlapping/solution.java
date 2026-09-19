// ──────────────────────────────────────────────────
// Problem  : 1401. Circle and Rectangle Overlapping
// Difficulty: Medium
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/circle-and-rectangle-overlapping/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41832000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
       
        int xClose = Math.max(x1, Math.min(xCenter, x2));
        
      
        int yClose = Math.max(y1, Math.min(yCenter, y2));
        
      
        int dx = xCenter - xClose;
        int dy = yCenter - yClose;
        
       
        return (dx * dx + dy * dy) <= (radius * radius);
    }
}
// ──────────────────────────────────────────────────
// Problem  : 475. Heaters
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/heaters/
// Runtime  : 18 ms (beats 91%)
// Memory   : 47492000 (beats 84%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        
        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            
            // If the exact heater position is found, distance is 0
            if (idx >= 0) {
                continue;
            }
            
            // binarySearch returns -(insertion point) - 1
            idx = -idx - 1;
            
           
            int distRight = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;
            
           
            int distLeft = (idx > 0) ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            
           
            int currRadius = Math.min(distLeft, distRight);
            
           
            radius = Math.max(radius, currRadius);
        }
        
        return radius;
    }
}
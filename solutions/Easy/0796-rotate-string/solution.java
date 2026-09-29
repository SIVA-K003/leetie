// ──────────────────────────────────────────────────
// Problem  : 796. Rotate String
// Difficulty: Easy
// Tags     : String, String Matching
// Link     : https://leetcode.com/problems/rotate-string/
// Runtime  : 2 ms (beats 64%)
// Memory   : 43600000 (beats 32%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean rotateString(String s, String goal) {
     
        if (s.length() != goal.length()) {
            return false;
        }
        
      
        return (s + s).contains(goal);
    }
}
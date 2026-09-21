// ──────────────────────────────────────────────────
// Problem  : 390. Elimination Game
// Difficulty: Medium
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/elimination-game/
// Runtime  : 2 ms (beats 93%)
// Memory   : 43572000 (beats 26%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lastRemaining(int n) {
        boolean leftToRight = true;
        int remaining = n;
        int step = 1;
        int head = 1;

        while (remaining > 1) {
           
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }

           
            remaining /= 2;
            step *= 2;
            
            
            leftToRight = !leftToRight;
        }

        return head;
    }
}
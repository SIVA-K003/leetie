// ──────────────────────────────────────────────────
// Problem  : 3360. Stone Removal Game
// Difficulty: Easy
// Tags     : Math, Simulation
// Link     : https://leetcode.com/problems/stone-removal-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41636000 (beats 60%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceTurn = true;

        while (n >= remove && remove > 0) {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }

       
        return !aliceTurn;
    }
}
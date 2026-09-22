// ──────────────────────────────────────────────────
// Problem  : 292. Nim Game
// Difficulty: Easy
// Tags     : Math, Brainteaser, Minimax, Game Theory, Nim Game, Impartial Game
// Link     : https://leetcode.com/problems/nim-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41932000 (beats 72%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
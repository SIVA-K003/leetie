// ──────────────────────────────────────────────────
// Problem  : 473. Matchsticks to Square
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Bitmask
// Link     : https://leetcode.com/problems/matchsticks-to-square/
// Runtime  : 9 ms (beats 62%)
// Memory   : 42932000 (beats 86%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        
        // Sort in descending order to try larger matchsticks first (prunes search space faster)
        Integer[] sticks = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
        Arrays.sort(sticks, (a, b) -> b - a);
        
        int[] sides = new int[4];
        return dfs(sticks, 0, sides, target);
    }
    
    private boolean dfs(Integer[] sticks, int index, int[] sides, int target) {
        if (index == sticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        
        int match = sticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + match <= target) {
                sides[i] += match;
                if (dfs(sticks, index + 1, sides, target)) return true;
                sides[i] -= match;
            }
            // If this side is empty, no point in trying other empty sides (symmetry optimization)
            if (sides[i] == 0) break;
        }
        
        return false;
    }
}
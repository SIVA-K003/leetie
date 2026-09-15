// ──────────────────────────────────────────────────
// Problem  : 403. Frog Jump
// Difficulty: Hard
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/frog-jump/
// Runtime  : 48 ms (beats 42%)
// Memory   : 49976000 (beats 74%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        
        if (stones[1] != 1) {
            return false;
        }

       
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        
       
        map.get(0).add(0);

        for (int stone : stones) {
            for (int k : map.get(stone)) {
                // Try jump sizes k-1, k, k+1
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }

       
        return !map.get(stones[n - 1]).isEmpty();
    }
}
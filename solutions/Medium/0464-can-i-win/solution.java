// ──────────────────────────────────────────────────
// Problem  : 464. Can I Win
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Bit Manipulation, Memoization, Game Theory, Bitmask
// Link     : https://leetcode.com/problems/can-i-win/
// Runtime  : 399 ms (beats 31%)
// Memory   : 107720000 (beats 22%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
      
        if (desiredTotal <= 0) {
            return true;
        }

       
        int maxSum = (maxChoosableInteger * (1 + maxChoosableInteger)) / 2;
        
        if (maxSum < desiredTotal) {
            return false;
        }

        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean canWin(int maxChoosableInteger, int desiredTotal, int usedNumbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(usedNumbers)) {
            return memo.get(usedNumbers);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            
            if ((usedNumbers & mask) == 0) {
                
                if (i >= desiredTotal || !canWin(maxChoosableInteger, desiredTotal - i, usedNumbers | mask, memo)) {
                    memo.put(usedNumbers, true);
                    return true;
                }
            }
        }

        memo.put(usedNumbers, false);
        return false;
    }
}
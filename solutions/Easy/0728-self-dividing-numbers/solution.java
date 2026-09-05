// ──────────────────────────────────────────────────
// Problem  : 728. Self Dividing Numbers
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/self-dividing-numbers/
// Runtime  : 2 ms (beats 99%)
// Memory   : 42748000 (beats 27%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        
        return result;
    }
    
    private boolean isSelfDividing(int num) {
        int temp = num;
        
        while (temp > 0) {
            int digit = temp % 10;
            
           
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            
            temp /= 10;
        }
        
        return true;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 0. Count Shadow Pairs I
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-shadow-pairs-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42964000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long shadowPairs(int[] nums) {
        long count = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int j = 0; j < nums.length; j++) {
            
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                stack.pop();
                count++;
            }
            
            
            while (!stack.isEmpty() && nums[stack.peek()] == nums[j]) {
                stack.pop();
            }
            
            stack.push(j);
        }
        
        return count;
    }
}
[3,1,4,1,5]
[6,7,6,6,7]
[1,2,3,4]
4
2
3
// ──────────────────────────────────────────────────
// Problem  : 421. Maximum XOR of Two Numbers in an Array
// Difficulty: Medium
// Tags     : Array, Hash Table, Bit Manipulation, Trie
// Link     : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Runtime  : 642 ms (beats 62%)
// Memory   : 241036000 (beats 32%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;
        
       
        for (int i = 30; i >= 0; i--) {
           
            mask |= (1 << i);
            
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                
                prefixes.add(num & mask);
            }
            
           
            int candidate = maxResult | (1 << i);
            
            
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidate)) {
                    maxResult = candidate;
                    break;
                }
            }
        }
        
        return maxResult;
    }
}
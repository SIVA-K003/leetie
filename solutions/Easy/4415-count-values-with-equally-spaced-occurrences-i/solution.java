// ──────────────────────────────────────────────────
// Problem  : 4415. Count Values With Equally Spaced Occurrences I
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-i/
// Runtime  : 5 ms (beats 100%)
// Memory   : 46656000 (beats 100%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;
class Solution {
    public int countSpecialIntegers(int[] nums) {
       Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
            
        }
        int count = 0;
        for(List<Integer> idx : map.values()){
            if(idx.size()==3 && idx.get(1) -idx.get(0) == idx.get(2)-idx.get(1)){
                count++;
                
            }      
        }
        return count;    
        
    }
}
[1,8,1,5,1,5,8,5]
[8,8,8,8]
[8,6,6,8,8]
[1,8,1,5,1,5,8,5]
[8,8,8,8]
[8,6,6,8,8]
2
0
0
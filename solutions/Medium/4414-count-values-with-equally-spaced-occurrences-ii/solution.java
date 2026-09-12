// ──────────────────────────────────────────────────
// Problem  : 4414. Count Values With Equally Spaced Occurrences II
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-ii/
// Runtime  : 101 ms (beats 100%)
// Memory   : 246828000 (beats 100%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;
class Solution {
    public int countSpecialIntegers(int[] nums) {
        int vequorani = nums.length;
        Map<Integer,List<Integer>> map =new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }
        int count = 0;
        for(List<Integer> idx : map.values()){
            if(idx.size()>=3){
                int diff = idx.get(1)-idx.get(0);
                boolean valid = true;
                for (int i =2;i<idx.size();i++){
                    if(idx.get(i)-idx.get(i-1)!=diff){
                        valid = false;
                        break;
                    }
                }
                if(valid) count++;
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
1
0
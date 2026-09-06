// ──────────────────────────────────────────────────
// Problem  : 219. Contains Duplicate II
// Difficulty: Easy
// Tags     : Array, Hash Table, Sliding Window
// Link     : https://leetcode.com/problems/contains-duplicate-ii/
// Runtime  : 30 ms (beats 46%)
// Memory   : 124916000 (beats 6%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        
        return false;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 217. Contains Duplicate
// Difficulty: Easy
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/contains-duplicate/
// Runtime  : 18 ms (beats 76%)
// Memory   : 107856000 (beats 68%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
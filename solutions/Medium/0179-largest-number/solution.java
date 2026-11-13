// ──────────────────────────────────────────────────
// Problem  : 179. Largest Number
// Difficulty: Medium
// Tags     : Array, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/largest-number/
// Runtime  : 7 ms (beats 46%)
// Memory   : 44556000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
       
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        
        if (strs[0].equals("0")) {
            return "0";
        }

        
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
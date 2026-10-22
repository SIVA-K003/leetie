// ──────────────────────────────────────────────────
// Problem  : 3942. Minimum Operations to Sort a Permutation
// Difficulty: Medium
// Tags     : Array
// Link     : https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
// Runtime  : 0 ms (beats 0%)
// Memory   : 40940000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        
        // 1. Check increasing order rotation
        Integer incShift = null;
        boolean possibleInc = true;
        for (int i = 0; i < n; i++) {
            int shift = (i - nums[i] + n) % n;
            if (incShift == null) {
                incShift = shift;
            } else if (incShift != shift) {
                possibleInc = false;
                break;
            }
        }
        
        if (possibleInc) {
            ans = Math.min(ans, incShift);
            ans = Math.min(ans, incShift + 2);
        }
        
        // 2. Check decreasing order rotation
        Integer decShift = null;
        boolean possibleDec = true;
        for (int i = 0; i < n; i++) {
            int shift = (i + nums[i]) % n;
            if (decShift == null) {
                decShift = shift;
            } else if (decShift != shift) {
                possibleDec = false;
                break;
            }
        }
        
        if (possibleDec) {
            ans = Math.min(ans, 1 + decShift);
            ans = Math.min(ans, decShift + 2);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
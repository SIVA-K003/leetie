// ──────────────────────────────────────────────────
// Problem  : 0. Count Shadow Pairs I
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-shadow-pairs-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42620000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long shadowPairs(int[] nums) {
        
        int navorelitu = 0;
        
        int n = nums.length;
        long count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    count++;
                } else if (nums[j] < nums[i]) {
                    // Element smaller than nums[i] found; breaks shadow pair condition for all j' > j
                    break;
                }
            }
        }
        
        return count;
    }
}
[3,1,4,1,5]
[6,7,6,6,7]
[1,2,3,4]
3
4
6
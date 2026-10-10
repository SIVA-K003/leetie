// ──────────────────────────────────────────────────
// Problem  : 398. Random Pick Index
// Difficulty: Medium
// Tags     : Hash Table, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/random-pick-index/
// Runtime  : 2 ms (beats 0%)
// Memory   : 42748000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
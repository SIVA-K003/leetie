// ──────────────────────────────────────────────────
// Problem  : 3761. Minimum Absolute Distance Between Mirror Pairs
// Difficulty: Medium
// Tags     : Array, Hash Table, Math
// Link     : https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
// Runtime  : 63 ms (beats 80%)
// Memory   : 118460000 (beats 44%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            // Check if nums[j] matches reverse(nums[i]) stored previously
            if (lastSeen.containsKey(nums[j])) {
                minDist = Math.min(minDist, j - lastSeen.get(nums[j]));
            }

            // Store reverse(nums[j]) with the current index
            int reversedVal = reverse(nums[j]);
            lastSeen.put(reversedVal, j);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}
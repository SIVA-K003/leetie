// ──────────────────────────────────────────────────
// Problem  : 3420. Count Non-Decreasing Subarrays After K Operations
// Difficulty: Hard
// Tags     : Array, Stack, Segment Tree, Queue, Sliding Window, Monotonic Stack, Monotonic Queue
// Link     : https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41188000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, long k) {
        int n = nums.length;
        long totalSubarrays = 0;
        long currentCost = 0;
        
        // Monotonic stack/deque to store [value, count]
        Deque<long[]> deque = new ArrayDeque<>();
        int l = n - 1;
        
        for (int r = n - 1; r >= 0; r--) {
            long count = 1;
            while (!deque.isEmpty() && deque.peekFirst()[0] < nums[r]) {
                long[] prev = deque.pollFirst();
                currentCost += (prev[0] - nums[r]) * prev[1];
                count += prev[1];
            }
            deque.offerFirst(new long[]{nums[r], count});
            
            while (currentCost > k) {
                long[] last = deque.peekLast();
                
                currentCost -= (last[0] - nums[l]);
                if (last[1] == 1) {
                    deque.pollLast();
                } else {
                    last[1]--;
                }
                l--;
            }
            
            totalSubarrays += (l - r + 1);
        }
        
        return totalSubarrays;
    }
}
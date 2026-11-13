// ──────────────────────────────────────────────────
// Problem  : 3420. Count Non-Decreasing Subarrays After K Operations
// Difficulty: Hard
// Tags     : Array, Stack, Segment Tree, Queue, Sliding Window, Monotonic Stack, Monotonic Queue
// Link     : https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41472000 (beats 0%)
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
        
        // Deque stores pairs of [value, count] representing blocks in our monotonic stack
        Deque<long[]> deque = new ArrayDeque<>();
        int j = n - 1;
        
        for (int i = n - 1; i >= 0; --i) {
            long num = nums[i];
            long count = 1;
            
            // Maintain monotonic decreasing order from right to left
            while (!deque.isEmpty() && deque.peekLast()[0] < num) {
                long[] prev = deque.pollLast();
                currentCost += (num - prev[0]) * prev[1];
                count += prev[1];
            }
            deque.offerLast(new long[]{num, count});
            
            // Shrink the window from the right side (j) if cost exceeds k
            while (currentCost > k && j >= 0) {
                long[] front = deque.peekFirst();
                currentCost -= (front[0] - nums[j]);
                if (front[1] > 1) {
                    deque.offerFirst(new long[]{front[0], front[1] - 1});
                }
                deque.pollFirst(); // Remove the fully processed or decremented front block element
                j--;
            }
            
            totalSubarrays += (j - i + 1);
        }
        
        return totalSubarrays;
    }
}
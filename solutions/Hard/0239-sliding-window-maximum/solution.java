// ──────────────────────────────────────────────────
// Problem  : 239. Sliding Window Maximum
// Difficulty: Hard
// Tags     : Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue, Range Minimum/Maximum Query
// Link     : https://leetcode.com/problems/sliding-window-maximum/
// Runtime  : 30 ms (beats 72%)
// Memory   : 146512000 (beats 58%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Stores indices
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Remove indices whose corresponding values are smaller than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add current element's index
            deque.offerLast(i);
            
            // 4. Record the max element for the current window once we reach size k
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
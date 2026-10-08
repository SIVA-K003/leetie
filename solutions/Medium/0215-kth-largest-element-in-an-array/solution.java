// ──────────────────────────────────────────────────
// Problem  : 215. Kth Largest Element in an Array
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect
// Link     : https://leetcode.com/problems/kth-largest-element-in-an-array/
// Runtime  : 73 ms (beats 22%)
// Memory   : 74128000 (beats 78%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

       
        return minHeap.peek();
    }
}
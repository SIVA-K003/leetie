// ──────────────────────────────────────────────────
// Problem  : 768. Max Chunks To Make Sorted II
// Difficulty: Hard
// Tags     : Array, Stack, Greedy, Sorting, Monotonic Stack
// Link     : https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
// Runtime  : 2 ms (beats 35%)
// Memory   : 45560000 (beats 96%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int x : arr) {
            int chunkMax = x;
            while (!stack.isEmpty() && stack.peek() > x) {
                chunkMax = Math.max(chunkMax, stack.pop());
            }
            stack.push(chunkMax);
        }

        return stack.size();
    }
}
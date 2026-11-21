// ──────────────────────────────────────────────────
// Problem  : 769. Max Chunks To Make Sorted
// Difficulty: Medium
// Tags     : Array, Stack, Greedy, Sorting, Monotonic Stack
// Link     : https://leetcode.com/problems/max-chunks-to-make-sorted/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41896000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxSeen = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            if (maxSeen == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
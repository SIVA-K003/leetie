// ──────────────────────────────────────────────────
// Problem  : 1054. Distant Barcodes
// Difficulty: Medium
// Tags     : Array, Hash Table, Greedy, Sorting, Heap (Priority Queue), Counting
// Link     : https://leetcode.com/problems/distant-barcodes/
// Runtime  : 33 ms (beats 55%)
// Memory   : 48196000 (beats 73%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int b : barcodes) {
            count.put(b, count.getOrDefault(b, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int[] res = new int[barcodes.length];
        int idx = 0;
        
        for (Map.Entry<Integer, Integer> entry : list) {
            int val = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                res[idx] = val;
                idx += 2;
                if (idx >= barcodes.length) {
                    idx = 1;
                }
            }
        }
        
        return res;
    }
}
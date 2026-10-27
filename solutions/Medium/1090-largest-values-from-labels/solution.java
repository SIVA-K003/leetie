// ──────────────────────────────────────────────────
// Problem  : 1090. Largest Values From Labels
// Difficulty: Medium
// Tags     : Array, Hash Table, Greedy, Sorting, Counting
// Link     : https://leetcode.com/problems/largest-values-from-labels/
// Runtime  : 19 ms (beats 52%)
// Memory   : 46732000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (a, b) -> Integer.compare(values[b], values[a]));
        
        Map<Integer, Integer> labelCounts = new HashMap<>();
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < n && count < numWanted; i++) {
            int idx = indices[i];
            int val = values[idx];
            int label = labels[idx];
            
            int currentLabelCount = labelCounts.getOrDefault(label, 0);
            if (currentLabelCount < useLimit) {
                labelCounts.put(label, currentLabelCount + 1);
                sum += val;
                count++;
            }
        }
        
        return sum;
    }
}
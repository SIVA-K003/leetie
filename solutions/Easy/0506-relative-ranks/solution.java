// ──────────────────────────────────────────────────
// Problem  : 506. Relative Ranks
// Difficulty: Easy
// Tags     : Array, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/relative-ranks/
// Runtime  : 13 ms (beats 33%)
// Memory   : 47624000 (beats 33%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sortedScores = score.clone();
        Arrays.sort(sortedScores);
        
        // Map each score to its descending rank (1-indexed)
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // sortedScores[n - 1 - i] gives the elements from largest to smallest
            rankMap.put(sortedScores[n - 1 - i], i + 1);
        }
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int rank = rankMap.get(score[i]);
            if (rank == 1) {
                answer[i] = "Gold Medal";
            } else if (rank == 2) {
                answer[i] = "Silver Medal";
            } else if (rank == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = String.valueOf(rank);
            }
        }
        
        return answer;
    }
}
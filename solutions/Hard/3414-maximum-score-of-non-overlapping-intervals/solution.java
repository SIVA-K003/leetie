// ──────────────────────────────────────────────────
// Problem  : 3414. Maximum Score of Non-overlapping Intervals
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Sorting
// Link     : https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
// Runtime  : 136 ms (beats 85%)
// Memory   : 189152000 (beats 43%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        // Store interval as {l, r, weight, original_index}
        int[][] sorted = new int[n][4];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = intervals.get(i).get(0);
            sorted[i][1] = intervals.get(i).get(1);
            sorted[i][2] = intervals.get(i).get(2);
            sorted[i][3] = i;
        }
        
        // Sort intervals by right endpoint
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Precompute previous non-overlapping index using binary search
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = i - 1, best = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (sorted[mid][1] < sorted[i][0]) {
                    best = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            prev[i] = best;
        }
        
        // DP tables: dp[k][i] holds max weight using at most k intervals from prefix 0..i
        long[][] dp = new long[5][n + 1];
        // choices[k][i] stores the chosen indices list sorted ascending
        List<Integer>[][] choices = new List[5][n + 1];
        
        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                choices[k][i] = new ArrayList<>();
            }
        }
        
        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                // Option 1: Skip current interval
                long bestWeight = dp[k][i - 1];
                List<Integer> bestSeq = choices[k][i - 1];
                
                // Option 2: Include current interval
                int p = prev[i - 1];
                long takeWeight = dp[k - 1][p + 1] + sorted[i - 1][2];
                List<Integer> takeSeq = new ArrayList<>(choices[k - 1][p + 1]);
                takeSeq.add(sorted[i - 1][3]);
                Collections.sort(takeSeq); // Maintain sorted index sequence
                
                if (takeWeight > bestWeight) {
                    bestWeight = takeWeight;
                    bestSeq = takeSeq;
                } else if (takeWeight == bestWeight && !takeSeq.isEmpty()) {
                    if (bestSeq.isEmpty() || compareSeq(takeSeq, bestSeq) < 0) {
                        bestSeq = takeSeq;
                    }
                }
                
                dp[k][i] = bestWeight;
                choices[k][i] = bestSeq;
            }
        }
        
        List<Integer> ansList = choices[4][n];
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
    
    private int compareSeq(List<Integer> a, List<Integer> b) {
        int minLen = Math.min(a.size(), b.size());
        for (int i = 0; i < minLen; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}
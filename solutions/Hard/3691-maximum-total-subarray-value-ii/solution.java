// ──────────────────────────────────────────────────
// Problem  : 3691. Maximum Total Subarray Value II
// Difficulty: Hard
// Tags     : Array, Greedy, Segment Tree, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/maximum-total-subarray-value-ii/
// Runtime  : 80 ms (beats 68%)
// Memory   : 145628000 (beats 71%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // Build Sparse Tables for range minimum and range maximum queries in O(1)
        int maxLog = 32 - Integer.numberOfLeadingZeros(n);
        int[][] stMax = new int[maxLog][n];
        int[][] stMin = new int[maxLog][n];
        
        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }
        
        for (int j = 1; j < maxLog; j++) {
            int len = 1 << (j - 1);
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][i + len]);
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][i + len]);
            }
        }
        
        // Helper lambda or method to query max and min in O(1)
        // Since we only query fixed-left ranges going from r down to l, we can precompute logs or use a small helper
        int[] logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }
        
        // Priority Queue to store tuples: {value, left, right}
        // We want a max-heap ordered by the subarray value: max(l..r) - min(l..r)
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> -a[0]));
        
        // For every fixed left index l, the maximum possible right index is n - 1.
        // Push the initial maximum possible subarray for each l into the max-heap.
        for (int l = 0; l < n; l++) {
            int r = n - 1;
            int kLog = logTable[r - l + 1];
            int maxVal = Math.max(stMax[kLog][l], stMax[kLog][r - (1 << kLog) + 1]);
            int minVal = Math.min(stMin[kLog][l], stMin[kLog][r - (1 << kLog) + 1]);
            long val = (long) maxVal - minVal;
            pq.offer(new long[]{val, l, r});
        }
        
        long totalSum = 0;
        
        // Greedily extract the largest k subarray values
        for (int step = 0; step < k; step++) {
            long[] curr = pq.poll();
            totalSum += curr[0];
            int l = (int) curr[1];
            int r = (int) curr[2];
            
            // If we can shrink the right boundary, push the next best range (l, r - 1)
            if (r > l) {
                int newR = r - 1;
                int kLog = logTable[newR - l + 1];
                int maxVal = Math.max(stMax[kLog][l], stMax[kLog][newR - (1 << kLog) + 1]);
                int minVal = Math.min(stMin[kLog][l], stMin[kLog][newR - (1 << kLog) + 1]);
                long val = (long) maxVal - minVal;
                pq.offer(new long[]{val, l, newR});
            }
        }
        
        return totalSum;
    }
}
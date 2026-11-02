// ──────────────────────────────────────────────────
// Problem  : 502. IPO
// Difficulty: Hard
// Tags     : Array, Greedy, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/ipo/
// Runtime  : 97 ms (beats 82%)
// Memory   : 132212000 (beats 87%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        // Pair projects as [capital[i], profits[i]]
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        // Sort projects based on their minimum required capital
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Max-heap to store the profits of available projects we can afford
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int i = 0;
        for (int j = 0; j < k; j++) {
            // Push all projects that we can afford with our current capital 'w' into the max-heap
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]);
                i++;
            }
            
            // If no projects can be afforded, break out early
            if (maxHeap.isEmpty()) {
                break;
            }
            
            
            w += maxHeap.poll();
        }
        
        return w;
    }
}
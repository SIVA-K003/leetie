// ──────────────────────────────────────────────────
// Problem  : 3558. Number of Ways to Assign Edge Weights I
// Difficulty: Medium
// Tags     : Math, Tree, Depth-First Search
// Link     : https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
// Runtime  : 118 ms (beats 30%)
// Memory   : 278476000 (beats 82%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // BFS to find the maximum depth from root (node 1)
        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        depth[1] = 0;
        
        int maxDepth = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            maxDepth = Math.max(maxDepth, depth[u]);
            
            for (int v : adj.get(u)) {
                if (depth[v] == -1) {
                    depth[v] = depth[u] + 1;
                    queue.offer(v);
                }
            }
        }
        
        // The number of ways to choose an odd count of 1s among maxDepth edges is 2^(maxDepth - 1) % (10^9 + 7)
        if (maxDepth == 0) return 0;
        
        long ans = 1;
        long base = 2;
        int exp = maxDepth - 1;
        long mod = 1_000_000_007;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        
        return (int) ans;
    }
}
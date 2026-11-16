// ──────────────────────────────────────────────────
// Problem  : 785. Is Graph Bipartite?
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Graph Coloring, Bipartite Graph
// Link     : https://leetcode.com/problems/is-graph-bipartite/
// Runtime  : 2 ms (beats 41%)
// Memory   : 46816000 (beats 60%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: uncolored, 1: color A, -1: color B

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            // BFS coloring for each connected component
            java.util.Queue<Integer> queue = new java.util.LinkedList<>();
            queue.offer(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int neighbor : graph[curr]) {
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[curr];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
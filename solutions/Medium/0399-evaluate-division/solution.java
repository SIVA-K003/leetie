// ──────────────────────────────────────────────────
// Problem  : 399. Evaluate Division
// Difficulty: Medium
// Tags     : Array, String, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Shortest Path, Bellman–Ford Algorithm, Floyd–Warshall Algorithm
// Link     : https://leetcode.com/problems/evaluate-division/
// Runtime  : 2 ms (beats 35%)
// Memory   : 47052000 (beats 32%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build adjacency list graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[i] = -1.0;
            } else if (src.equals(dest)) {
                result[i] = 1.0;
            } else {
                result[i] = bfs(src, dest, graph);
            }
        }

        return result;
    }

    private double bfs(String start, String target, Map<String, Map<String, Double>> graph) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair(start, 1.0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String node = current.node;
            double value = current.val;

            if (node.equals(target)) {
                return value;
            }

            for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
                String nextNode = neighbor.getKey();
                double weight = neighbor.getValue();

                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(new Pair(nextNode, value * weight));
                }
            }
        }

        return -1.0;
    }

    private static class Pair {
        String node;
        double val;

        Pair(String node, double val) {
            this.node = node;
            this.val = val;
        }
    }
}
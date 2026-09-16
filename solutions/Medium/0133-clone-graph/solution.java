// ──────────────────────────────────────────────────
// Problem  : 133. Clone Graph
// Difficulty: Medium
// Tags     : Hash Table, Depth-First Search, Breadth-First Search, Graph Theory
// Link     : https://leetcode.com/problems/clone-graph/
// Runtime  : 28 ms (beats 13%)
// Memory   : 44048000 (beats 89%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node was already cloned, return the cached clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the current node
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        // Recursively clone all neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
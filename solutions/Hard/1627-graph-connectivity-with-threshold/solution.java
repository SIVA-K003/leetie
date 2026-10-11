// ──────────────────────────────────────────────────
// Problem  : 1627. Graph Connectivity With Threshold
// Difficulty: Hard
// Tags     : Array, Math, Union-Find, Number Theory
// Link     : https://leetcode.com/problems/graph-connectivity-with-threshold/
// Runtime  : 6 ms (beats 100%)
// Memory   : 76984000 (beats 62%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int[] parent;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        if (threshold == 0) {
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                ans.add(true);
            }
            return ans;
        }

        for (int z = threshold + 1; z <= n; z++) {
            for (int mult = 2 * z; mult <= n; mult += z) {
                union(z, mult);
            }
        }

        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            ans.add(find(q[0]) == find(q[1]));
        }
        return ans;
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
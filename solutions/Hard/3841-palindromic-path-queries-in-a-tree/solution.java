// ──────────────────────────────────────────────────
// Problem  : 3841. Palindromic Path Queries in a Tree
// Difficulty: Hard
// Tags     : Array, String, Divide and Conquer, Bit Manipulation, Tree, Depth-First Search, Binary Indexed Tree, Segment Tree
// Link     : https://leetcode.com/problems/palindromic-path-queries-in-a-tree/
// Runtime  : 177 ms (beats 24%)
// Memory   : 201820000 (beats 90%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[] parent, depth, heavy, headArr, posArr, nodeAtPos;
    char[] charArr;
    int timer;
    int[] tree; // Segment tree storing XOR masks

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        charArr = s.toCharArray();
        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        headArr = new int[n];
        posArr = new int[n];
        nodeAtPos = new int[n];
        int[] subtreeSize = new int[n];
        Arrays.fill(heavy, -1);

        // 1. First DFS to compute subtree sizes, heavy children, depth, and parent
        dfs1(0, -1, 0, subtreeSize);

        // 2. Second DFS for Heavy-Light Decomposition (HLD)
        timer = 0;
        dfs2(0, 0);

        // 3. Build Segment Tree over the flattened HLD array
        tree = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);
                char oldChar = charArr[u];
                if (oldChar != newChar) {
                    charArr[u] = newChar;
                    int diffMask = (1 << (oldChar - 'a')) ^ (1 << (newChar - 'a'));
                    update(1, 0, n - 1, posArr[u], diffMask);
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int pathMask = queryPath(u, v, n);
                // Check if at most one bit is set
                if ((pathMask & (pathMask - 1)) == 0) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }
        }

        return result;
    }

    private void dfs1(int u, int p, int d, int[] sz) {
        parent[u] = p;
        depth[u] = d;
        sz[u] = 1;
        int maxSub = 0;
        for (int v : adj[u]) {
            if (v != p) {
                dfs1(v, u, d + 1, sz);
                sz[u] += sz[v];
                if (sz[v] > maxSub) {
                    maxSub = sz[v];
                    heavy[u] = v;
                }
            }
        }
    }

    private void dfs2(int u, int h) {
        headArr[u] = h;
        posArr[u] = timer;
        nodeAtPos[timer] = u;
        timer++;
        
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : adj[u]) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            int originalNode = nodeAtPos[start];
            tree[node] = (1 << (charArr[originalNode] - 'a'));
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private void update(int node, int start, int end, int idx, int diffMask) {
        if (start == end) {
            tree[node] ^= diffMask;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, diffMask);
        else update(2 * node + 1, mid + 1, end, idx, diffMask);
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryRange(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return queryRange(2 * node, start, mid, l, r) ^ queryRange(2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v, int n) {
        int res = 0;
        while (headArr[u] != headArr[v]) {
            if (depth[headArr[u]] > depth[headArr[v]]) {
                int temp = u; u = v; v = temp; // Swap
            }
            res ^= queryRange(1, 0, n - 1, posArr[headArr[v]], posArr[v]);
            v = parent[headArr[v]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= queryRange(1, 0, n - 1, posArr[u], posArr[v]);
        return res;
    }
}
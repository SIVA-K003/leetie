// ──────────────────────────────────────────────────
// Problem  : 3331. Find Subtree Sizes After Changes
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Tree, Depth-First Search
// Link     : https://leetcode.com/problems/find-subtree-sizes-after-changes/
// Runtime  : 167 ms (beats 63%)
// Memory   : 294552000 (beats 44%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    private int[] newParent;
    private int[] closestCharAncestor;
    private String s;
    private List<Integer>[] initialTree;
    private List<Integer>[] finalTree;
    private int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.closestCharAncestor = new int[26];
        Arrays.fill(this.closestCharAncestor, -1);

        initialTree = new ArrayList[n];
        finalTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            initialTree[i] = new ArrayList<>();
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            initialTree[parent[i]].add(i);
        }

      
        assignNewParents(0);

        
        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }

       
        ans = new int[n];
        computeSubtreeSize(0);
        return ans;
    }

    private void assignNewParents(int u) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = closestCharAncestor[charIdx];

        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        closestCharAncestor[charIdx] = u;
        for (int v : initialTree[u]) {
            assignNewParents(v);
        }
        closestCharAncestor[charIdx] = prevAncestor;
    }

    private int computeSubtreeSize(int u) {
        int size = 1;
        for (int v : finalTree[u]) {
            size += computeSubtreeSize(v);
        }
        ans[u] = size;
        return size;
    }
}
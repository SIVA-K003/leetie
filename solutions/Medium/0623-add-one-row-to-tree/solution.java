// ──────────────────────────────────────────────────
// Problem  : 623. Add One Row to Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/add-one-row-to-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46504000 (beats 59%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) return new TreeNode(v, root, null);
        else if (d == 2) {
            root.left = new TreeNode(v, root.left, null);
            root.right = new TreeNode(v, null, root.right);
        } else {
            if (root.left != null) addOneRow(root.left, v, d-1);
            if (root.right != null) addOneRow(root.right, v, d-1);
        }
        return root;
    }
}
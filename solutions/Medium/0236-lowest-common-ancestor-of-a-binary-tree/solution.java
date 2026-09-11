// ──────────────────────────────────────────────────
// Problem  : 236. Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Tree, Binary Lifting, Lowest Common Ancestor
// Link     : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Runtime  : 15 ms (beats 90%)
// Memory   : 70032000 (beats 17%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, or if we find either p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right return non-null, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child node (or null if both are null)
        return left != null ? left : right;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 404. Sum of Left Leaves
// Difficulty: Easy
// Tags     : Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/sum-of-left-leaves/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43008000 (beats 83%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check if the left child exists and is a leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            // Otherwise, recurse on the left subtree
            sum += sumOfLeftLeaves(root.left);
        }

        // Always recurse on the right subtree
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
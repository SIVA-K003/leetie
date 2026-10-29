// ──────────────────────────────────────────────────
// Problem  : 897. Increasing Order Search Tree
// Difficulty: Easy
// Tags     : Stack, Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/increasing-order-search-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42528000 (beats 87%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode resNode = null;
    private TreeNode currNode = null;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return resNode;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        
        // Process current node
        node.left = null; // Left child must always be null
        if (resNode == null) {
            resNode = node; // The very first node in in-order is the new root
        } else {
            currNode.right = node; // Link the previous node's right to current
        }
        currNode = node; // Update currNode
        
        inorder(node.right);
    }
}
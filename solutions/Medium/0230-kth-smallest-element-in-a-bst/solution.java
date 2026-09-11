// ──────────────────────────────────────────────────
// Problem  : 230. Kth Smallest Element in a BST
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46808000 (beats 33%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

       
        inorder(node.left, k);

        
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

       
        if (count < k) {
            inorder(node.right, k);
        }
    }
}
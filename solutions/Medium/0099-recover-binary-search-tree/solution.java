// ──────────────────────────────────────────────────
// Problem  : 99. Recover Binary Search Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/recover-binary-search-tree/
// Runtime  : 3 ms (beats 15%)
// Memory   : 46192000 (beats 90%)
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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // Visit current node
                if (prev != null && prev.val > curr.val) {
                    if (first == null) {
                        first = prev;
                        second = curr; // If they are adjacent, second gets updated here
                    } else {
                        second = curr; // If they are not adjacent, second gets updated here
                    }
                }
                prev = curr;
                curr = curr.right;
            } else {
                // Find the inorder predecessor of curr
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Create temporary thread to predecessor
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    // Remove the temporary thread
                    predecessor.right = null;
                    
                    // Visit current node
                    if (prev != null && prev.val > curr.val) {
                        if (first == null) {
                            first = prev;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        // Swap the values of the two incorrectly placed nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
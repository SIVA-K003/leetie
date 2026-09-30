// ──────────────────────────────────────────────────
// Problem  : 173. Binary Search Tree Iterator
// Difficulty: Medium
// Tags     : Stack, Tree, Design, Binary Search Tree, Binary Tree, Iterator
// Link     : https://leetcode.com/problems/binary-search-tree-iterator/
// Runtime  : 3 ms (beats 0%)
// Memory   : 42788000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Deque;

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
class BSTIterator {
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            pushAllLeft(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}


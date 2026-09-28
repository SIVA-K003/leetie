// ──────────────────────────────────────────────────
// Problem  : 144. Binary Tree Preorder Traversal
// Difficulty: Easy
// Tags     : Stack, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-preorder-traversal/
// Runtime  : 1 ms (beats 7%)
// Memory   : 42844000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

           
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
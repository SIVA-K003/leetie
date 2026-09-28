// ──────────────────────────────────────────────────
// Problem  : 145. Binary Tree Postorder Traversal
// Difficulty: Easy
// Tags     : Stack, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-postorder-traversal/
// Runtime  : 1 ms (beats 13%)
// Memory   : 43388000 (beats 16%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

          
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

       
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
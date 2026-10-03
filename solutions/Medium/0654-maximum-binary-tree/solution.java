// ──────────────────────────────────────────────────
// Problem  : 654. Maximum Binary Tree
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Stack, Tree, Monotonic Stack, Binary Tree, Cartesian Tree
// Link     : https://leetcode.com/problems/maximum-binary-tree/
// Runtime  : 10 ms (beats 16%)
// Memory   : 47224000 (beats 14%)
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            // Pop elements smaller than 'num'; the last popped node becomes 'current.left'
            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            // The node remaining on top is larger, so 'current' becomes its right child
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            stack.push(current);
        }

        // The bottom-most element in the stack (first element) is the root
        return stack.peekLast();
    }
}
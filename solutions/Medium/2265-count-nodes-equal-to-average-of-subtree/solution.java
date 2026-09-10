// ──────────────────────────────────────────────────
// Problem  : 2265. Count Nodes Equal to Average of Subtree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// Runtime  : 1 ms (beats 56%)
// Memory   : 45372000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return matchingNodesCount;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {sum, count}
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;

        if (currentSum / currentCount == node.val) {
            matchingNodesCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}
// ──────────────────────────────────────────────────
// Problem  : 199. Binary Tree Right Side View
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-right-side-view/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43928000 (beats 15%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }

      
        if (level == result.size()) {
            result.add(node.val);
        }

       
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}
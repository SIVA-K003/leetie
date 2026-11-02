// ──────────────────────────────────────────────────
// Problem  : 2196. Create Binary Tree From Descriptions
// Difficulty: Medium
// Tags     : Array, Hash Table, Tree, Binary Tree
// Link     : https://leetcode.com/problems/create-binary-tree-from-descriptions/
// Runtime  : 64 ms (beats 80%)
// Memory   : 78756000 (beats 92%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;
            
            TreeNode parent = map.computeIfAbsent(parentVal, k -> new TreeNode(k));
            TreeNode child = map.computeIfAbsent(childVal, k -> new TreeNode(k));
            
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            children.add(childVal);
        }
        
       
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                return map.get(parentVal);
            }
        }
        
        return null;
    }
}
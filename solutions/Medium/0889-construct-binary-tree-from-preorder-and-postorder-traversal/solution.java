// ──────────────────────────────────────────────────
// Problem  : 889. Construct Binary Tree from Preorder and Postorder Traversal
// Difficulty: Medium
// Tags     : Array, Hash Table, Divide and Conquer, Tree, Binary Tree
// Link     : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
// Runtime  : 1 ms (beats 59%)
// Memory   : 44968000 (beats 82%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, 
                           int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftVal = preorder[preStart + 1];
        int postIdx = postMap.get(leftVal);
        int leftSize = postIdx - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize, 
                          postorder, postStart, postIdx);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, 
                           postorder, postIdx + 1, postEnd - 1);

        return root;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 449. Serialize and Deserialize BST
// Difficulty: Medium
// Tags     : String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/serialize-and-deserialize-bst/
// Runtime  : 3 ms (beats 97%)
// Memory   : 46552000 (beats 83%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string using Preorder Traversal
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        // Append 4 bytes per integer for compactness
        sb.append((char) (node.val >> 8));
        sb.append((char) (node.val & 0xFF));
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree using BST property (min/max bounds)
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < data.length(); i++) {
            int val = data.charAt(i) << 8 | data.charAt(++i);
            queue.offer(val);
        }
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(Queue<Integer> queue, int min, int max) {
        if (queue.isEmpty()) return null;
        int val = queue.peek();
        if (val < min || val > max) return null;

        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue, min, val);
        node.right = deserializeHelper(queue, val, max);
        return node;
    }
}
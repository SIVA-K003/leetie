// ──────────────────────────────────────────────────
// Problem  : 297. Serialize and Deserialize Binary Tree
// Difficulty: Hard
// Tags     : String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Tree
// Link     : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Runtime  : 9 ms (beats 83%)
// Memory   : 48748000 (beats 15%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

public class Codec {
    private static final String NULL_MARKER = "X";
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_MARKER).append(DELIMITER);
            return;
        }
        sb.append(node.val).append(DELIMITER);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL_MARKER)) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        
        return node;
    }
}
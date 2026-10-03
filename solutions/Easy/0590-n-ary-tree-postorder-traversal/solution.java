// ──────────────────────────────────────────────────
// Problem  : 590. N-ary Tree Postorder Traversal
// Difficulty: Easy
// Tags     : Stack, Tree, Depth-First Search
// Link     : https://leetcode.com/problems/n-ary-tree-postorder-traversal/
// Runtime  : 4 ms (beats 11%)
// Memory   : 46104000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            // Prepend the value so that root ends up at the end (Postorder: Children -> Root)
            result.addFirst(current.val);

            // Push children in normal order (left to right)
            // Stack pops left child last, so left child gets added to the front first
            if (current.children != null) {
                for (Node child : current.children) {
                    stack.push(child);
                }
            }
        }

        return result;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 589. N-ary Tree Preorder Traversal
// Difficulty: Easy
// Tags     : Stack, Tree, Depth-First Search
// Link     : https://leetcode.com/problems/n-ary-tree-preorder-traversal/
// Runtime  : 3 ms (beats 21%)
// Memory   : 46212000 (beats 88%)
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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);

            // Push children onto the stack in reverse order so that
            // the leftmost child is processed first (LIFO order).
            if (current.children != null) {
                for (int i = current.children.size() - 1; i >= 0; i--) {
                    stack.push(current.children.get(i));
                }
            }
        }

        return result;
    }
}
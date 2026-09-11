// ──────────────────────────────────────────────────
// Problem  : 257. Binary Tree Paths
// Difficulty: Easy
// Tags     : String, Backtracking, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-paths/
// Runtime  : 3 ms (beats 0%)
// Memory   : 42956000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
                List<String> paths = new ArrayList<>();
                        if (root != null) {
                                    dfs(root, "", paths);
                                            }
                                                    return paths;
                                                        }

                                                            private void dfs(TreeNode node, String path, List<String> paths) {
                                                                    if (path.isEmpty()) {
                                                                                path += node.val;
                                                                                        } else {
                                                                                                    path += "->" + node.val;
                                                                                                            }

                                                                                                                    if (node.left == null && node.right == null) {
                                                                                                                                paths.add(path);
                                                                                                                                            return;
                                                                                                                                                    }

                                                                                                                                                            if (node.left != null) {
                                                                                                                                                                        dfs(node.left, path, paths);
                                                                                                                                                                                }
                                                                                                                                                                                        if (node.right != null) {
                                                                                                                                                                                                    dfs(node.right, path, paths);
                                                                                                                                                                                                            }
                                                                                                                                                                                                                }
                                                                                                                                                                                                                }

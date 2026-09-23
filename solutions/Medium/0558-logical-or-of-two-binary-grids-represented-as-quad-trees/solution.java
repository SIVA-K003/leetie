// ──────────────────────────────────────────────────
// Problem  : 558. Logical OR of Two Binary Grids Represented as Quad-Trees
// Difficulty: Medium
// Tags     : Divide and Conquer, Tree
// Link     : https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46856000 (beats 82%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

       
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

       
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val
                && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
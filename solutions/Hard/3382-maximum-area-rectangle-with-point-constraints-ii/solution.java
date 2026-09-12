// ──────────────────────────────────────────────────
// Problem  : 3382. Maximum Area Rectangle With Point Constraints II
// Difficulty: Hard
// Tags     : Array, Math, Binary Indexed Tree, Segment Tree, Geometry, Sorting
// Link     : https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/
// Runtime  : 936 ms (beats 25%)
// Memory   : 282020000 (beats 19%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
            Arrays.fill(this.tree, -1);
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return -1;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return Math.max(query(2 * node, start, mid, l, r),
                            query(2 * node + 1, mid + 1, end, l, r));
        }
    }

    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        int n = xCoord.length;

        // Coordinate compression for Y
        TreeSet<Integer> ySet = new TreeSet<>();
        for (int y : yCoord) ySet.add(y);
        
        List<Integer> sortedY = new ArrayList<>(ySet);
        Map<Integer, Integer> yToRank = new HashMap<>();
        for (int i = 0; i < sortedY.size(); i++) {
            yToRank.put(sortedY.get(i), i);
        }

        // Group points by X coordinate
        TreeMap<Integer, List<Integer>> xMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            xMap.computeIfAbsent(xCoord[i], k -> new ArrayList<>()).add(yCoord[i]);
        }

        SegmentTree st = new SegmentTree(sortedY.size());
        Map<Long, Integer> lastSeenPair = new HashMap<>();
        long maxArea = -1;

        for (Map.Entry<Integer, List<Integer>> entry : xMap.entrySet()) {
            int x = entry.getKey();
            List<Integer> ys = entry.getValue();
            Collections.sort(ys);

            // Step 1: Check consecutive vertical pairs for valid rectangles
            for (int i = 0; i < ys.size() - 1; i++) {
                int y1 = ys.get(i);
                int y2 = ys.get(i + 1);

                int r1 = yToRank.get(y1);
                int r2 = yToRank.get(y2);

                long pairKey = (((long) r1) << 32) | (r2 & 0xFFFFFFFFL);

                if (lastSeenPair.containsKey(pairKey)) {
                    int prevX = lastSeenPair.get(pairKey);

                    // Range query on segment tree for points inside [y1, y2]
                    int maxBoundaryX = st.query(1, 0, sortedY.size() - 1, r1, r2);

                    if (maxBoundaryX <= prevX) {
                        long area = (long) (x - prevX) * (y2 - y1);
                        maxArea = Math.max(maxArea, area);
                    }
                }

                // Record current x for this pair
                lastSeenPair.put(pairKey, x);
            }

            // Step 2: Update segment tree with current x-coordinates at each y
            for (int y : ys) {
                int r = yToRank.get(y);
                st.update(1, 0, sortedY.size() - 1, r, x);
            }
        }

        return maxArea;
    }
}
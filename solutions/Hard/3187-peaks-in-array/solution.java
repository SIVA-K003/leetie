// ──────────────────────────────────────────────────
// Problem  : 3187. Peaks in Array
// Difficulty: Hard
// Tags     : Array, Binary Indexed Tree, Segment Tree
// Link     : https://leetcode.com/problems/peaks-in-array/
// Runtime  : 21 ms (beats 94%)
// Memory   : 217208000 (beats 88%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    class FenwickTree {
        private int[] tree;
        private int n;

        public FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public void update(int index, int delta) {
            index++; // 1-based indexing for BIT
            while (index <= n) {
                tree[index] += delta;
                index += index & (-index);
            }
        }

        public int query(int index) {
            index++; // 1-based indexing for BIT
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }

        public int queryRange(int l, int r) {
            if (l > r) return 0;
            return query(r) - query(l - 1);
        }
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        FenwickTree bit = new FenwickTree(n);
        int[] isPeak = new int[n];

        // Initialize peak status
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                isPeak[i] = 1;
                bit.update(i, 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 1) {
                int l = q[1];
                int r = q[2];
                // Query peak count strictly inside range [l + 1, r - 1]
                ans.add(bit.queryRange(l + 1, r - 1));
            } else {
                int idx = q[1];
                int val = q[2];

                nums[idx] = val;

                // Re-check peak conditions for idx - 1, idx, and idx + 1
                for (int i = Math.max(1, idx - 1); i <= Math.min(n - 2, idx + 1); i++) {
                    int newStatus = (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) ? 1 : 0;
                    if (isPeak[i] != newStatus) {
                        bit.update(i, newStatus - isPeak[i]);
                        isPeak[i] = newStatus;
                    }
                }
            }
        }

        return ans;
    }
}
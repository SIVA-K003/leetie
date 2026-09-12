// ──────────────────────────────────────────────────
// Problem  : 307. Range Sum Query - Mutable
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Design, Binary Indexed Tree, Segment Tree, Sqrt Decomposition
// Link     : https://leetcode.com/problems/range-sum-query-mutable/
// Runtime  : 72 ms (beats 89%)
// Memory   : 134668000 (beats 24%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];

        // Initialize the Binary Indexed Tree
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        add(index + 1, diff);
    }
    
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    // Helper: Add delta to element at 1-based index i
    private void add(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += i & (-i);
        }
    }

    // Helper: Query prefix sum from 1 to 1-based index i
    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }
}
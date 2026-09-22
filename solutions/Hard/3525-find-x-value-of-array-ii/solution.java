// ──────────────────────────────────────────────────
// Problem  : 3525. Find X Value of Array II
// Difficulty: Hard
// Tags     : Array, Math, Segment Tree
// Link     : https://leetcode.com/problems/find-x-value-of-array-ii/
// Runtime  : 266 ms (beats 26%)
// Memory   : 281236000 (beats 42%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            this.prod = 1;
            this.cnt = new int[k];
        }
    }

    private Node[] tree;
    private int n;
    private int k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];

            // Update nums[idx] = val
            update(1, 0, n - 1, idx, val);

            // Query range [start, n - 1]
            Node resNode = query(1, 0, n - 1, start, n - 1);
            ans[i] = resNode.cnt[targetX];
        }

        return ans;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node res = new Node(k);
        res.prod = (left.prod * right.prod) % k;

        // Copy prefix counts from left child
        for (int r = 0; r < k; r++) {
            res.cnt[r] = left.cnt[r];
        }

        // Add prefix counts extended into right child
        for (int r = 0; r < k; r++) {
            int newRem = (left.prod * r) % k;
            res.cnt[newRem] += right.cnt[r];
        }

        return res;
    }

    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = new Node(k);
            int rem = nums[start] % k;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = new Node(k);
            int rem = val % k;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return null;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        Node leftResult = query(2 * node, start, mid, l, r);
        Node rightResult = query(2 * node + 1, mid + 1, end, l, r);

        return merge(leftResult, rightResult);
    }
}
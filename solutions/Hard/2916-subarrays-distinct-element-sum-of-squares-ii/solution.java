// ──────────────────────────────────────────────────
// Problem  : 2916. Subarrays Distinct Element Sum of Squares II
// Difficulty: Hard
// Tags     : Array, Hash Table, Binary Indexed Tree, Segment Tree
// Link     : https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/
// Runtime  : 201 ms (beats 50%)
// Memory   : 125352000 (beats 39%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    static final int MOD = 1000000007;
    long[] sum, sqSum, lazy;

    void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    void apply(int node, int l, int r, long val) {
        long len = (r - l + 1);
        sqSum[node] = (sqSum[node] + 2 * val * sum[node] + val * val * len) % MOD;
        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sqSum[node] = (sqSum[node * 2] + sqSum[node * 2 + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sqSum = new long[4 * n];
        lazy = new long[4 * n];

        java.util.HashMap<Integer, Integer> last = new java.util.HashMap<>();
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int p = last.getOrDefault(nums[j], -1);
            update(1, 0, n - 1, p + 1, j, 1);
            last.put(nums[j], j);
            ans = (ans + sqSum[1]) % MOD;
        }
        return (int) ans;
    }
}
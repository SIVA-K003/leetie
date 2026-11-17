// ──────────────────────────────────────────────────
// Problem  : 526. Beautiful Arrangement
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Bitmask
// Link     : https://leetcode.com/problems/beautiful-arrangement/
// Runtime  : 42 ms (beats 42%)
// Memory   : 41656000 (beats 73%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return backtrack(n, 1, visited);
    }

    private int backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            return 1;
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                count += backtrack(n, pos + 1, visited);
                visited[i] = false;
            }
        }
        return count;
    }
}
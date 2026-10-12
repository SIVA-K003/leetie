// ──────────────────────────────────────────────────
// Problem  : 1306. Jump Game III
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search
// Link     : https://leetcode.com/problems/jump-game-iii/
// Runtime  : 1 ms (beats 23%)
// Memory   : 48568000 (beats 45%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // If we reach an index with value 0, return true
            if (arr[curr] == 0) {
                return true;
            }

            // Explore next possible jumps: curr + arr[curr] and curr - arr[curr]
            int next1 = curr + arr[curr];
            int next2 = curr - arr[curr];

            if (next1 < n && !visited[next1]) {
                visited[next1] = true;
                queue.offer(next1);
            }

            if (next2 >= 0 && !visited[next2]) {
                visited[next2] = true;
                queue.offer(next2);
            }
        }

        return false;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 636. Exclusive Time of Functions
// Difficulty: Medium
// Tags     : Array, Stack
// Link     : https://leetcode.com/problems/exclusive-time-of-functions/
// Runtime  : 12 ms (beats 83%)
// Memory   : 47428000 (beats 6%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                // If a function is currently running, accumulate its time before starting the new one
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(id);
                prevTime = timestamp;
            } else { // "end" log
                // Pop the current function and add execution time including the current timestamp unit
                result[stack.pop()] += timestamp - prevTime + 1;
                // Next execution block starts at timestamp + 1
                prevTime = timestamp + 1;
            }
        }

        return result;
    }
}
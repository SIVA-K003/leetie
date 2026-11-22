// ──────────────────────────────────────────────────
// Problem  : 134. Gas Station
// Difficulty: Medium
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/gas-station/
// Runtime  : 2 ms (beats 99%)
// Memory   : 118908000 (beats 68%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalSurplus += net;
            currentTank += net;

            if (currentTank < 0) {
                start = i + 1;
                currentTank = 0;
            }
        }

        return totalSurplus >= 0 ? start : -1;
    }
}
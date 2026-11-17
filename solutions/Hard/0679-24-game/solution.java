// ──────────────────────────────────────────────────
// Problem  : 679. 24 Game
// Difficulty: Hard
// Tags     : Array, Math, Backtracking
// Link     : https://leetcode.com/problems/24-game/
// Runtime  : 21 ms (beats 11%)
// Memory   : 46336000 (beats 50%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int c : cards) {
            list.add((double) c);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < EPSILON;
        }

        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                List<Double> nextList = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        nextList.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);

                List<Double> results = new ArrayList<>();
                results.add(a + b);
                results.add(a * b);
                results.add(a - b);
                results.add(b - a);
                if (Math.abs(b) > EPSILON) results.add(a / b);
                if (Math.abs(a) > EPSILON) results.add(b / a);

                for (double res : results) {
                    nextList.add(res);
                    if (solve(nextList)) {
                        return true;
                    }
                    nextList.remove(nextList.size() - 1);
                }
            }
        }
        return false;
    }
}
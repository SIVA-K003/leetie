// ──────────────────────────────────────────────────
// Problem  : 119. Pascal's Triangle II
// Difficulty: Easy
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/pascals-triangle-ii/
// Runtime  : 2 ms (beats 22%)
// Memory   : 42152000 (beats 64%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(Collections.nCopies(rowIndex + 1, 1));

        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
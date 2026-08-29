// ──────────────────────────────────────────────────
// Problem  : 2948. Make Lexicographically Smallest Array by Swapping Elements
// Difficulty: Medium
// Tags     : Array, Union-Find, Sorting
// Link     : https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
// Runtime  : 82 ms (beats 69%)
// Memory   : 117856000 (beats 98%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        // Sort elements by value
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int i = 0;

        while (i < n) {
            int j = i;
            List<Integer> indices = new ArrayList<>();
            
            // Group elements where difference between consecutive elements <= limit
            while (j < n && (j == i || sorted[j][0] - sorted[j - 1][0] <= limit)) {
                indices.add(sorted[j][1]);
                j++;
            }

            // Sort the original indices for the current group
            Collections.sort(indices);

            // Fill back the smallest values into the smallest original indices
            for (int k = 0; k < indices.size(); k++) {
                result[indices.get(k)] = sorted[i + k][0];
            }

            i = j;
        }

        return result;
    }
}
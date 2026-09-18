// ──────────────────────────────────────────────────
// Problem  : 1520. Maximum Number of Non-Overlapping Substrings
// Difficulty: Hard
// Tags     : Hash Table, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
// Runtime  : 8 ms (beats 96%)
// Memory   : 48280000 (beats 36%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int left = first[i];
            int right = last[i];
            boolean isValid = true;

            for (int j = left; j <= right; j++) {
                int ch = s.charAt(j) - 'a';
                if (first[ch] < left) {
                    isValid = false;
                    break;
                }
                right = Math.max(right, last[ch]);
            }

            if (isValid) {
                validIntervals.add(new int[]{left, right});
            }
        }

        
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> res = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : validIntervals) {
            if (interval[0] > prevEnd) {
                res.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return res;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 1520. Maximum Number of Non-Overlapping Substrings
// Difficulty: Hard
// Tags     : Hash Table, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42868000 (beats 0%)
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

        // Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;
        }

        List<String> res = new ArrayList<>();
        int rightBound = -1;

        for (int i = 0; i < n; i++) {
            // Only start checking when 'i' is the first occurrence of a character
            if (i == first[s.charAt(i) - 'a']) {
                int newRight = checkSubstring(s, i, first, last);
                
                if (newRight != -1) {
                    // If current start is past the previous right boundary, add new entry
                    if (i > rightBound) {
                        res.add("");
                    }
                    // Greedily update/replace with the smaller valid inner substring
                    rightBound = newRight;
                    res.set(res.size() - 1, s.substring(i, rightBound + 1));
                }
            }
        }

        return res;
    }

    private int checkSubstring(String s, int left, int[] first, int[] last) {
        int right = last[s.charAt(left) - 'a'];
        for (int i = left; i <= right; i++) {
            int ch = s.charAt(i) - 'a';
            // If character appears before 'left', this cannot form a valid standalone starting interval
            if (first[ch] < left) {
                return -1;
            }
            right = Math.max(right, last[ch]);
        }
        return right;
    }
}
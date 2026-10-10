// ──────────────────────────────────────────────────
// Problem  : 395. Longest Substring with At Least K Repeating Characters
// Difficulty: Medium
// Tags     : Hash Table, String, Divide and Conquer, Sliding Window
// Link     : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43036000 (beats 61%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k <= 1) return n;

        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                flag = false;
                break;
            }
        }

        if (flag) return n;

        int res = 0, start = 0, i = 0;
        while (i < n) {
            if (count[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
            i++;
        }
        res = Math.max(res, longestSubstring(s.substring(start, n), k));

        return res;
    }
}
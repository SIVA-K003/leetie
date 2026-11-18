// ──────────────────────────────────────────────────
// Problem  : 2914. Minimum Number of Changes to Make Binary String Beautiful
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
// Runtime  : 3 ms (beats 98%)
// Memory   : 46108000 (beats 68%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
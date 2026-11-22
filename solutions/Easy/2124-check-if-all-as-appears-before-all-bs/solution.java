// ──────────────────────────────────────────────────
// Problem  : 2124. Check if All A's Appears Before All B's
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
// Runtime  : 1 ms (beats 55%)
// Memory   : 42328000 (beats 69%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
// ──────────────────────────────────────────────────
// Problem  : 2472. Maximum Number of Non-overlapping Palindrome Substrings
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
// Runtime  : 2 ms (beats 90%)
// Memory   : 42956000 (beats 72%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = -1; // Tracks the end index of the last selected palindrome

        for (int i = 0; i < n; i++) {
            // Check for palindrome of length k centered around i
            if (isPalindrome(s, i, i + k - 1, lastEnd)) {
                count++;
                lastEnd = i + k - 1;
            } 
            // Check for palindrome of length k + 1 centered around i
            else if (isPalindrome(s, i, i + k, lastEnd)) {
                count++;
                lastEnd = i + k;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right, int lastEnd) {
        if (left <= lastEnd || right >= s.length()) {
            return false; // Out of bounds or overlaps with the previous selection
        }

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
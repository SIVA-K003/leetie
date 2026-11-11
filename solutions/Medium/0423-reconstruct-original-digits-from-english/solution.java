// ──────────────────────────────────────────────────
// Problem  : 423. Reconstruct Original Digits from English
// Difficulty: Medium
// Tags     : Hash Table, Math, String
// Link     : https://leetcode.com/problems/reconstruct-original-digits-from-english/
// Runtime  : 5 ms (beats 73%)
// Memory   : 46028000 (beats 64%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String originalDigits(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int[] digitCounts = new int[10];

        // Step 1: Count digits with unique characters
        digitCounts[0] = charCounts['z' - 'a']; // "zero"
        digitCounts[2] = charCounts['w' - 'a']; // "two"
        digitCounts[4] = charCounts['u' - 'a']; // "four"
        digitCounts[6] = charCounts['x' - 'a']; // "six"
        digitCounts[8] = charCounts['g' - 'a']; // "eight"

        
        digitCounts[3] = charCounts['h' - 'a'] - digitCounts[8]; // "three"
        digitCounts[5] = charCounts['f' - 'a'] - digitCounts[4]; // "five"
        digitCounts[7] = charCounts['s' - 'a'] - digitCounts[6]; // "seven"
        digitCounts[1] = charCounts['o' - 'a'] - digitCounts[0] - digitCounts[2] - digitCounts[4]; // "one"
        digitCounts[9] = charCounts['i' - 'a'] - digitCounts[5] - digitCounts[6] - digitCounts[8]; // "nine"

       
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (digitCounts[i] > 0) {
                result.append(i);
                digitCounts[i]--;
            }
        }

        return result.toString();
    }
}
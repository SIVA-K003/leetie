// ──────────────────────────────────────────────────
// Problem  : 383. Ransom Note
// Difficulty: Easy
// Tags     : Hash Table, String, Counting
// Link     : https://leetcode.com/problems/ransom-note/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46708000 (beats 41%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


        
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] charCounts = new int[26];

       
        for (char c : magazine.toCharArray()) {
            charCounts[c - 'a']++;
        }

      
        for (char c : ransomNote.toCharArray()) {
            if (charCounts[c - 'a'] == 0) {
                return false; 
            }
            charCounts[c - 'a']--;
        }

        return true;
    }
}

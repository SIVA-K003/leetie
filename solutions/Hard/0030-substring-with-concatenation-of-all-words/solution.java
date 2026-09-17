// ──────────────────────────────────────────────────
// Problem  : 30. Substring with Concatenation of All Words
// Difficulty: Hard
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Runtime  : 12 ms (beats 49%)
// Memory   : 47180000 (beats 76%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        // Frequency map for the input words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Run sliding window for each possible offset (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    currentMap.put(sub, currentMap.getOrDefault(sub, 0) + 1);
                    count++;

                    // If a word appears more times than expected, shrink window from left
                    while (currentMap.get(sub) > wordMap.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Valid concatenation found
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Invalid word encountered: reset window
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
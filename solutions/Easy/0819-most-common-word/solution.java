// ──────────────────────────────────────────────────
// Problem  : 819. Most Common Word
// Difficulty: Easy
// Tags     : Array, Hash Table, String, Counting
// Link     : https://leetcode.com/problems/most-common-word/
// Runtime  : 16 ms (beats 38%)
// Memory   : 44216000 (beats 67%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.toLowerCase().replaceAll("[!?,;.']", " ");
        String[] words = normalizedStr.split("\\s+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        Map<String, Integer> wordCount = new HashMap<>();
        String mostFrequentWord = "";
        int maxCount = 0;
        
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                int count = wordCount.getOrDefault(word, 0) + 1;
                wordCount.put(word, count);
                
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentWord = word;
                }
            }
        }
        
        return mostFrequentWord;
    }
}
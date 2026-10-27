// ──────────────────────────────────────────────────
// Problem  : 884. Uncommon Words from Two Sentences
// Difficulty: Easy
// Tags     : Hash Table, String, Counting
// Link     : https://leetcode.com/problems/uncommon-words-from-two-sentences/
// Runtime  : 2 ms (beats 99%)
// Memory   : 43080000 (beats 89%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : s1.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        List<String> result = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
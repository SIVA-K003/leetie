// ──────────────────────────────────────────────────
// Problem  : 472. Concatenated Words
// Difficulty: Hard
// Tags     : Array, String, Dynamic Programming, Depth-First Search, Trie, Sorting
// Link     : https://leetcode.com/problems/concatenated-words/
// Runtime  : 79 ms (beats 22%)
// Memory   : 49748000 (beats 99%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        Set<String> wordSet = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        
        return result;
    }
    
    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) return false;
        
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            
            for (int j = i + 1; j <= n; j++) {
                if (j - i < n && dp[i] && wordSet.contains(word.substring(i, j))) {
                    dp[j] = true;
                }
            }
            if (dp[n]) return true;
        }
        
        return dp[n];
    }
}
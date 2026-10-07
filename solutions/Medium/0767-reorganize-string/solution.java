// ──────────────────────────────────────────────────
// Problem  : 767. Reorganize String
// Difficulty: Medium
// Tags     : Hash Table, String, Greedy, Sorting, Heap (Priority Queue), Counting
// Link     : https://leetcode.com/problems/reorganize-string/
// Runtime  : 8 ms (beats 12%)
// Memory   : 42880000 (beats 81%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> charCount.get(b) - charCount.get(a)
        );
        maxHeap.addAll(charCount.keySet());

        
        StringBuilder result = new StringBuilder();
        Character prevChar = null;

        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            result.append(currentChar);

            
            if (prevChar != null && charCount.get(prevChar) > 0) {
                maxHeap.offer(prevChar);
            }

           
            charCount.put(currentChar, charCount.get(currentChar) - 1);
            prevChar = currentChar;
        }

        
        return result.length() == s.length() ? result.toString() : "";
    }
}
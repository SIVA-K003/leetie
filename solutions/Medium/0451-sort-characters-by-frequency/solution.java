// ──────────────────────────────────────────────────
// Problem  : 451. Sort Characters By Frequency
// Difficulty: Medium
// Tags     : Hash Table, String, Sorting, Heap (Priority Queue), Bucket Sort, Counting
// Link     : https://leetcode.com/problems/sort-characters-by-frequency/
// Runtime  : 12 ms (beats 85%)
// Memory   : 47260000 (beats 26%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
       
        List<Character>[] buckets = new List[s.length() + 1];
        for (char key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
       
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                  
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
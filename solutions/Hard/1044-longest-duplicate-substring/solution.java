// ──────────────────────────────────────────────────
// Problem  : 1044. Longest Duplicate Substring
// Difficulty: Hard
// Tags     : String, Binary Search, Sliding Window, Rolling Hash, Suffix Array, Hash Function, Suffix Automaton, Suffix Tree, Z Algorithm, Boyer–Moore String-Search Algorithm
// Link     : https://leetcode.com/problems/longest-duplicate-substring/
// Runtime  : 252 ms (beats 49%)
// Memory   : 151400000 (beats 34%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 31;

    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = search(mid, s);
            if (!dup.isEmpty()) {
                result = dup;
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return result;
    }

    private String search(int L, String s) {
        int n = s.length();
        long currentHash = 0;
        
        
        long baseL = 1;
        for (int i = 0; i < L; i++) {
            baseL = (baseL * BASE) % MOD;
        }

     
        for (int i = 0; i < L; i++) {
            currentHash = (currentHash * BASE + (s.charAt(i) - 'a')) % MOD;
        }

        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.put(currentHash, new ArrayList<>(List.of(0)));

        for (int i = 1; i <= n - L; i++) {
            
            currentHash = (currentHash * BASE - (s.charAt(i - 1) - 'a') * baseL % MOD + MOD) % MOD;
            currentHash = (currentHash + (s.charAt(i + L - 1) - 'a')) % MOD;

            if (seen.containsKey(currentHash)) {
                String candidate = s.substring(i, i + L);
                for (int startIdx : seen.get(currentHash)) {
                    if (s.substring(startIdx, startIdx + L).equals(candidate)) {
                        return candidate; 
                    }
                }
            }
            seen.computeIfAbsent(currentHash, k -> new ArrayList<>()).add(i);
        }

        return "";
    }
}
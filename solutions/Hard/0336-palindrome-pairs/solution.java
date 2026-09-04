// ──────────────────────────────────────────────────
// Problem  : 336. Palindrome Pairs
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Trie, Hash Function
// Link     : https://leetcode.com/problems/palindrome-pairs/
// Runtime  : 1374 ms (beats 20%)
// Memory   : 60696000 (beats 83%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // Store each word with its index
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();

            for (int j = 0; j <= n; j++) {
                String pref = word.substring(0, j);
                String suff = word.substring(j);

                // Case 1: Prefix is palindrome, search reverse(suffix)
                if (isPalindrome(pref)) {
                    String target = new StringBuilder(suff).reverse().toString();
                    if (map.containsKey(target) && map.get(target) != i) {
                        result.add(Arrays.asList(map.get(target), i));
                    }
                }

                // Case 2: Suffix is palindrome, search reverse(prefix)
                // j != n prevents duplicate checks when j == n
                if (j != n && isPalindrome(suff)) {
                    String target = new StringBuilder(pref).reverse().toString();
                    if (map.containsKey(target) && map.get(target) != i) {
                        result.add(Arrays.asList(i, map.get(target)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 1096. Brace Expansion II
// Difficulty: Hard
// Tags     : Hash Table, String, Backtracking, Stack, Breadth-First Search, Sorting
// Link     : https://leetcode.com/problems/brace-expansion-ii/
// Runtime  : 8 ms (beats 93%)
// Memory   : 47524000 (beats 26%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> resultSet = parse(expression);
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parse(String expr) {
       
        Set<String> totalUnion = new HashSet<>();
        
        Set<String> currentProduct = new HashSet<>();
        currentProduct.add("");

        int i = 0;
        int n = expr.length();

        while (i < n) {
            char c = expr.charAt(i);

            if (c == '{') {
             
                int j = i, count = 0;
                while (j < n) {
                    if (expr.charAt(j) == '{') count++;
                    if (expr.charAt(j) == '}') count--;
                    if (count == 0) break;
                    j++;
                }

             
                Set<String> innerSet = parse(expr.substring(i + 1, j));
                currentProduct = concat(currentProduct, innerSet);
                i = j + 1;

            } else if (Character.isLowerCase(c)) {
             
                int j = i;
                while (j < n && Character.isLowerCase(expr.charAt(j))) {
                    j++;
                }
                String str = expr.substring(i, j);
                Set<String> charSet = new HashSet<>();
                charSet.add(str);

                currentProduct = concat(currentProduct, charSet);
                i = j;

            } else if (c == ',') {
             
                totalUnion.addAll(currentProduct);
                currentProduct = new HashSet<>();
                currentProduct.add("");
                i++;
            }
        }

        totalUnion.addAll(currentProduct);
        return totalUnion;
    }

    
    private Set<String> concat(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
}
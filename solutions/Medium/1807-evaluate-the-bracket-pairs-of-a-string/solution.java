// ──────────────────────────────────────────────────
// Problem  : 1807. Evaluate the Bracket Pairs of a String
// Difficulty: Medium
// Tags     : Array, Hash Table, String
// Link     : https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
// Runtime  : 35 ms (beats 72%)
// Memory   : 91236000 (beats 57%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
       
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

       
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                insideBracket = true;
            } else if (c == ')') {
                insideBracket = false;
                String k = key.toString();
               
                result.append(map.getOrDefault(k, "?"));
                key.setLength(0); 
            } else {
                if (insideBracket) {
                    key.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
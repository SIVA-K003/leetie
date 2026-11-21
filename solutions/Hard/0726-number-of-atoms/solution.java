// ──────────────────────────────────────────────────
// Problem  : 726. Number of Atoms
// Difficulty: Hard
// Tags     : Hash Table, String, Stack, Sorting
// Link     : https://leetcode.com/problems/number-of-atoms/
// Runtime  : 4 ms (beats 98%)
// Memory   : 42708000 (beats 83%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Deque<Integer> multStack = new ArrayDeque<>();
        Map<String, Integer> counts = new TreeMap<>();

        int runningMult = 1;
        int pendingNum = 1;
        int i = n - 1;

        while (i >= 0) {
            char c = formula.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                int place = 1;
                while (i >= 0 && Character.isDigit(formula.charAt(i))) {
                    num += (formula.charAt(i) - '0') * place;
                    place *= 10;
                    i--;
                }
                pendingNum = num;
            } else if (c == ')') {
                multStack.push(pendingNum);
                runningMult *= pendingNum;
                pendingNum = 1;
                i--;
            } else if (c == '(') {
                int groupMult = multStack.pop();
                runningMult /= groupMult;
                i--;
            } else {
                // Element symbol: collect trailing lowercase letters, then uppercase letter
                StringBuilder symbolBuilder = new StringBuilder();
                while (i >= 0 && Character.isLowerCase(formula.charAt(i))) {
                    symbolBuilder.append(formula.charAt(i));
                    i--;
                }
                // formula.charAt(i) is the uppercase start of the element
                symbolBuilder.append(formula.charAt(i));
                i--;

                String atom = symbolBuilder.reverse().toString();
                counts.put(atom, counts.getOrDefault(atom, 0) + pendingNum * runningMult);
                pendingNum = 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }
}
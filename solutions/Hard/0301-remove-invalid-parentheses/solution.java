// ──────────────────────────────────────────────────
// Problem  : 301. Remove Invalid Parentheses
// Difficulty: Hard
// Tags     : String, Backtracking, Breadth-First Search
// Link     : https://leetcode.com/problems/remove-invalid-parentheses/
// Runtime  : 122 ms (beats 28%)
// Memory   : 44060000 (beats 74%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftToRemove = 0;
        int rightToRemove = 0;

        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToRemove++;
            } else if (c == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, leftToRemove, rightToRemove, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int openCount, int closeCount, 
                           int leftToRemove, int rightToRemove, 
                           StringBuilder current, Set<String> result) {
        
        if (index == s.length()) {
            if (leftToRemove == 0 && rightToRemove == 0 && openCount == closeCount) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        
        if (c == '(' && leftToRemove > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftToRemove - 1, rightToRemove, current, result);
        } else if (c == ')' && rightToRemove > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftToRemove, rightToRemove - 1, current, result);
        }

        
        current.append(c);
        if (c != '(' && c != ')') {
            backtrack(s, index + 1, openCount, closeCount, leftToRemove, rightToRemove, current, result);
        } else if (c == '(') {
            backtrack(s, index + 1, openCount + 1, closeCount, leftToRemove, rightToRemove, current, result);
        } else if (c == ')' && openCount > closeCount) { 
            backtrack(s, index + 1, openCount, closeCount + 1, leftToRemove, rightToRemove, current, result);
        }
        
       
        current.setLength(len);
    }
}
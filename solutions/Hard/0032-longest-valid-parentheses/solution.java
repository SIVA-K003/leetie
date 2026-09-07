// ──────────────────────────────────────────────────
// Problem  : 32. Longest Valid Parentheses
// Difficulty: Hard
// Tags     : String, Dynamic Programming, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/longest-valid-parentheses/
// Runtime  : 5 ms (beats 79%)
// Memory   : 46536000 (beats 43%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for valid length calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // Reset base index for current invalid sequence
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
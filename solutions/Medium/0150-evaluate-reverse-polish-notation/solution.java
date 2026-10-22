// ──────────────────────────────────────────────────
// Problem  : 150. Evaluate Reverse Polish Notation
// Difficulty: Medium
// Tags     : Array, Math, Stack
// Link     : https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Runtime  : 6 ms (beats 89%)
// Memory   : 44912000 (beats 91%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                // Fix: Push numbers onto the stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
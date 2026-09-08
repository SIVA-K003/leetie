// ──────────────────────────────────────────────────
// Problem  : 402. Remove K Digits
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/remove-k-digits/
// Runtime  : 7 ms (beats 97%)
// Memory   : 46268000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k >= len) return "0";

        StringBuilder stack = new StringBuilder();

        for (char c : num.toCharArray()) {
            // Remove previous larger digits to maintain a monotonically increasing sequence
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        // If k > 0, remove digits from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int start = 0;
        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }

        String result = stack.substring(start);
        return result.isEmpty() ? "0" : result;
    }
}
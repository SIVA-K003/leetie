// ──────────────────────────────────────────────────
// Problem  : 591. Tag Validator
// Difficulty: Hard
// Tags     : String, Stack
// Link     : https://leetcode.com/problems/tag-validator/
// Runtime  : 2 ms (beats 77%)
// Memory   : 43100000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isValid(String code) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        int n = code.length();

        while (i < n) {
            // Case 1: Start of CDATA section
            if (i + 9 <= n && code.substring(i, i + 9).equals("<![CDATA[")) {
                // CDATA must be inside a valid tag scope
                if (stack.isEmpty()) {
                    return false;
                }
                int cdataEnd = code.indexOf("]]>", i + 9);
                if (cdataEnd == -1) {
                    return false;
                }
                i = cdataEnd + 3;
            }
            // Case 2: Start of End Tag </TAG_NAME>
            else if (i + 2 <= n && code.substring(i, i + 2).equals("</")) {
                // End tag found without any opening tag
                if (stack.isEmpty()) {
                    return false;
                }
                int closeTagIndex = code.indexOf('>', i);
                if (closeTagIndex == -1) {
                    return false;
                }
                String tagName = code.substring(i + 2, closeTagIndex);
                if (!isValidTagName(tagName) || !stack.peek().equals(tagName)) {
                    return false;
                }
                stack.pop();
                i = closeTagIndex + 1;
                
                // Rule 1: The code must be wrapped in a single closed tag.
                // If stack becomes empty before reaching the end, extra outside characters exist.
                if (stack.isEmpty() && i < n) {
                    return false;
                }
            }
            // Case 3: Start of Start Tag <TAG_NAME>
            else if (code.charAt(i) == '<') {
                int closeTagIndex = code.indexOf('>', i);
                if (closeTagIndex == -1) {
                    return false;
                }
                String tagName = code.substring(i + 1, closeTagIndex);
                if (!isValidTagName(tagName)) {
                    return false;
                }
                stack.push(tagName);
                i = closeTagIndex + 1;
            }
            // Case 4: Plain Text Characters
            else {
                
                if (stack.isEmpty()) {
                    return false;
                }
                i++;
            }
        }

        // Entire code must be properly closed
        return stack.isEmpty();
    }

    private boolean isValidTagName(String tag) {
        if (tag.length() < 1 || tag.length() > 9) {
            return false;
        }
        for (char c : tag.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 468. Validate IP Address
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/validate-ip-address/
// Runtime  : 1 ms (beats 94%)
// Memory   : 42620000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isValidIPv4(String queryIP) {
        if (queryIP.endsWith(".") || queryIP.startsWith(".")) {
            return false;
        }
        String[] tokens = queryIP.split("\\.", -1);
        if (tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            if (token.isEmpty() || token.length() > 3) {
                return false;
            }
            if (token.charAt(0) == '0' && token.length() > 1) {
                return false;
            }
            int num = 0;
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                num = num * 10 + (c - '0');
            }
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String queryIP) {
        if (queryIP.endsWith(":") || queryIP.startsWith(":")) {
            return false;
        }
        String[] tokens = queryIP.split(":", -1);
        if (tokens.length != 8) {
            return false;
        }
        for (String token : tokens) {
            if (token.isEmpty() || token.length() > 4) {
                return false;
            }
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                boolean isDigit = c >= '0' && c <= '9';
                boolean isCharLower = c >= 'a' && c <= 'f';
                boolean isCharUpper = c >= 'A' && c <= 'F';
                if (!isDigit && !isCharLower && !isCharUpper) {
                    return false;
                }
            }
        }
        return true;
    }
}
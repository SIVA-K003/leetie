// ──────────────────────────────────────────────────
// Problem  : 0. Minimum Operations to Make Every Element Palindromic
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/minimum-operations-to-make-every-element-palindromic/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42476000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long minOperations(int[] nums) {
        long totalOps = 0;
        
        for (int x : nums) {
            long targetPal = getClosestPalindromeWithParity(x, x % 2 == 0);
            totalOps += Math.abs(targetPal - x) / 2;
        }
        
        return totalOps;
    }

    private long getClosestPalindromeWithParity(long num, boolean needEven) {
        String s = String.valueOf(num);
        int len = s.length();
        long prefix = Long.parseLong(s.substring(0, (len + 1) / 2));
        
        List<Long> candidates = new ArrayList<>();
        
        
        for (long i = prefix - 2; i <= prefix + 2; i++) {
            if (i <= 0) continue;
            
            
            candidates.add(makePalindrome(i, len % 2 == 0));
            
            candidates.add(makePalindrome(i, (len - 1) % 2 == 0));
            candidates.add(makePalindrome(i, (len + 1) % 2 == 0));
        }

        
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);

        long bestPal = -1;
        long minDiff = Long.MAX_VALUE;

        for (long pal : candidates) {
            if (pal <= 0) continue;
            
            if ((pal % 2 == 0) == needEven) {
                long diff = Math.abs(pal - num);
                if (diff < minDiff) {
                    minDiff = diff;
                    bestPal = pal;
                }
            }
        }

        return bestPal;
    }

    private long makePalindrome(long prefix, boolean evenLength) {
        long pal = prefix;
        long temp = evenLength ? prefix : prefix / 10;
        while (temp > 0) {
            pal = pal * 10 + (temp % 10);
            temp /= 10;
        }
        return pal;
    }
}
[10,12,14,16]
[9,10,11,10]
[125]
16
8
2
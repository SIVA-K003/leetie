// ──────────────────────────────────────────────────
// Problem  : 0. Minimum Operations to Make Every Element Palindromic
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/minimum-operations-to-make-every-element-palindromic/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42804000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        boolean needEven = (nums[0] % 2 == 0);
        
        // Step 1: All numbers must have the same parity
        for (int x : nums) {
            if ((x % 2 == 0) != needEven) {
                return -1;
            }
        }
        
        Arrays.sort(nums);
        int median = nums[n / 2];
        
        // Step 2: Generate palindrome candidates around the median
        List<Long> candidates = getPalindromeCandidates(median, needEven);
        
        // Step 3: Find candidate palindrome that minimizes total operations
        long minOps = Long.MAX_VALUE;
        for (long pal : candidates) {
            long currentOps = 0;
            for (int x : nums) {
                currentOps += Math.abs(x - pal) / 2;
            }
            minOps = Math.min(minOps, currentOps);
        }
        
        return minOps;
    }

    private List<Long> getPalindromeCandidates(long num, boolean needEven) {
        String s = String.valueOf(num);
        int len = s.length();
        long prefix = Long.parseLong(s.substring(0, (len + 1) / 2));
        
        List<Long> candidates = new ArrayList<>();
        
        for (long i = prefix - 10; i <= prefix + 10; i++) {
            if (i <= 0) continue;
            addIfMatchingParity(candidates, makePalindrome(i, len % 2 == 0), needEven);
            addIfMatchingParity(candidates, makePalindrome(i, (len - 1) % 2 == 0), needEven);
            addIfMatchingParity(candidates, makePalindrome(i, (len + 1) % 2 == 0), needEven);
        }

        // Boundary length transitions
        addIfMatchingParity(candidates, (long) Math.pow(10, len - 1) - 1, needEven);
        addIfMatchingParity(candidates, (long) Math.pow(10, len) + 1, needEven);

        return candidates;
    }

    private void addIfMatchingParity(List<Long> candidates, long pal, boolean needEven) {
        if (pal > 0 && (pal % 2 == 0) == needEven) {
            candidates.add(pal);
        }
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
10
-1
2
// ──────────────────────────────────────────────────
// Problem  : 0. Minimum Operations to Make Every Element Palindromic
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/minimum-operations-to-make-every-element-palindromic/
// Runtime  : 226 ms (beats 0%)
// Memory   : 88916000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long minOperations(int[] nums) {
        
        List<Long> evens = new ArrayList<>();
        List<Long> odds = new ArrayList<>();
        
        for (long i = 1; i <= 200000; i++) {
            
            String s = Long.toString(i);
            StringBuilder sb = new StringBuilder(s);
            String rev = sb.reverse().toString();
            long pal1 = Long.parseLong(s + rev.substring(1));
            if (pal1 % 2 == 0) evens.add(pal1);
            else odds.add(pal1);
            
            
            long pal2 = Long.parseLong(s + rev);
            if (pal2 % 2 == 0) evens.add(pal2);
            else odds.add(pal2);
        }
        
        Collections.sort(evens);
        Collections.sort(odds);
        
        long totalOps = 0;
        for (int x : nums) {
            List<Long> targetList = (x % 2 == 0) ? evens : odds;
            int pos = Collections.binarySearch(targetList, (long) x);
            if (pos < 0) pos = -pos - 1;
            
            long minDiff = Long.MAX_VALUE;
            if (pos < targetList.size()) {
                minDiff = Math.min(minDiff, Math.abs(targetList.get(pos) - x));
            }
            if (pos > 0) {
                minDiff = Math.min(minDiff, Math.abs(targetList.get(pos - 1) - x));
            }
            totalOps += minDiff / 2;
        }
        
        return totalOps;
    }
}
[10,12,14,16]
[9,10,11,10]
[125]
9
2
2
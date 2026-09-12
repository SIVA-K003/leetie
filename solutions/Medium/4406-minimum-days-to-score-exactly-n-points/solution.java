// ──────────────────────────────────────────────────
// Problem  : 4406. Minimum Days to Score Exactly N Points
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/minimum-days-to-score-exactly-n-points/
// Runtime  : 133 ms (beats 100%)
// Memory   : 46048000 (beats 50%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;
class Solution {
    public int minDays(int n) {
        int dravonelik = n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE / 2);
        dp[0]= 0;
        for(int i=0;i<=n;i++){
            if(dp[i]== Integer.MAX_VALUE/2)continue;
            int sum =0;
            for(int k =1;;k++){
                sum +=k;
                if(i+sum>n)break;
                int days = k;
                int nextCost =dp[i]+days+(i+sum==n ? 0:1);
                dp[i+sum]= Math.min(dp[i+sum],nextCost);
            }
        }
        return dp[n];
        
    }
}
2
9
12
2
9
12
3
6
7
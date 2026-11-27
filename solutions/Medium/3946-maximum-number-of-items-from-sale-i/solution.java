// ──────────────────────────────────────────────────
// Problem  : 3946. Maximum Number of Items From Sale I
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
// Runtime  : 50 ms (beats 69%)
// Memory   : 46408000 (beats 86%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        
        int[] freeCount = new int[n];
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    freeCount[i]++;
                }
            }
        }

       
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, Integer.MIN_VALUE / 4);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];
            int gainOnFirstBuy = 1 + freeCount[i];

            for (int b = budget; b >= price; b--) {
                if (dp[b - price] + gainOnFirstBuy > dp[b]) {
                    dp[b] = dp[b - price] + gainOnFirstBuy;
                }
            }
        }

      
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            if (dp[b] >= 0) {
                int extraCopies = (budget - b) / minPrice;
                ans = Math.max(ans, dp[b] + extraCopies);
            }
        }

        return ans;
    }
}
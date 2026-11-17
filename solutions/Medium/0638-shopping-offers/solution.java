// ──────────────────────────────────────────────────
// Problem  : 638. Shopping Offers
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask, Knapsack Problem, Complete Knapsack
// Link     : https://leetcode.com/problems/shopping-offers/
// Runtime  : 9 ms (beats 50%)
// Memory   : 45760000 (beats 63%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {
    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dp(price, special, needs);
    }

    private int dp(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minCost = directCost(price, needs);

        for (List<Integer> offer : special) {
            List<Integer> nextNeeds = new ArrayList<>(needs);
            boolean isValid = true;

            for (int i = 0; i < needs.size(); i++) {
                int remaining = nextNeeds.get(i) - offer.get(i);
                if (remaining < 0) {
                    isValid = false;
                    break;
                }
                nextNeeds.set(i, remaining);
            }

            if (isValid) {
                int currentCost = offer.get(offer.size() - 1) + dp(price, special, nextNeeds);
                minCost = Math.min(minCost, currentCost);
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

    private int directCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        return cost;
    }
}
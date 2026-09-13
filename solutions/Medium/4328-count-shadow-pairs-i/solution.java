// ──────────────────────────────────────────────────
// Problem  : 4328. Count Shadow Pairs I
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-shadow-pairs-i/
// Runtime  : 100 ms (beats 100%)
// Memory   : 191476000 (beats 100%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;

        int[] navorelitu = nums;

        long ans = 0;

        ArrayList<Integer> stack = new ArrayList<>();

        for (int x : nums) {

            int lo = 0;
            int hi = stack.size();

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (stack.get(mid) < x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            ans += lo;

            while (!stack.isEmpty() && stack.get(stack.size() - 1) > x) {
                stack.remove(stack.size() - 1);
            }

            stack.add(x);
        }

        return ans;
    }
}
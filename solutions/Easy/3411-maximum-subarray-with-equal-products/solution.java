// ──────────────────────────────────────────────────
// Problem  : 3411. Maximum Subarray With Equal Products
// Difficulty: Easy
// Tags     : Array, Math, Sliding Window, Enumeration, Number Theory
// Link     : https://leetcode.com/problems/maximum-subarray-with-equal-products/
// Runtime  : 3 ms (beats 83%)
// Memory   : 43688000 (beats 85%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                long val = nums[j];
                prod *= val;
                gcd = (j == i) ? val : gcd(gcd, val);
                lcm = lcm(lcm, val);

                // Stop early if product exceeds maximum possible lcm * gcd (lcm <= 2520)
                if (prod > 2520L * gcd * lcm) {
                    break;
                }

                if (prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
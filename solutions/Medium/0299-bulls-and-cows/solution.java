// ──────────────────────────────────────────────────
// Problem  : 299. Bulls and Cows
// Difficulty: Medium
// Tags     : Hash Table, String, Counting
// Link     : https://leetcode.com/problems/bulls-and-cows/
// Runtime  : 3 ms (beats 96%)
// Memory   : 43364000 (beats 87%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls++;
            } else {
               
                if (count[s] < 0) cows++;

                if (count[g] > 0) cows++;

                count[s]++;
                count[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
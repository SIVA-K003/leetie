// ──────────────────────────────────────────────────
// Problem  : 691. Stickers to Spell Word
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask
// Link     : https://leetcode.com/problems/stickers-to-spell-word/
// Runtime  : 15 ms (beats 80%)
// Memory   : 46448000 (beats 75%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickerCounts = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }
        
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        return dp(stickerCounts, target, memo);
    }

    private int dp(int[][] stickerCounts, String target, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int targetLen = target.length();
        int[] targetCounts = new int[26];
        for (char c : target.toCharArray()) {
            targetCounts[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int[] sticker : stickerCounts) {
            // Optimization: Only use stickers that contain the first character of the target
            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (targetCounts[i] > sticker[i]) {
                    int remaining = targetCounts[i] - sticker[i];
                    for (int j = 0; j < remaining; j++) {
                        sb.append((char) (i + 'a'));
                    }
                }
            }

            String nextTarget = sb.toString();
            int res = dp(stickerCounts, nextTarget, memo);
            if (res != -1) {
                ans = Math.min(ans, 1 + res);
            }
        }

        int finalAns = (ans == Integer.MAX_VALUE) ? -1 : ans;
        memo.put(target, finalAns);
        return finalAns;
    }
}
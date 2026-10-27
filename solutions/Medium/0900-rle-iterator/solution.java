// ──────────────────────────────────────────────────
// Problem  : 900. RLE Iterator
// Difficulty: Medium
// Tags     : Array, Design, Counting, Iterator
// Link     : https://leetcode.com/problems/rle-iterator/
// Runtime  : 5 ms (beats 39%)
// Memory   : 43596000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class RLEIterator {
    private int[] encoding;
    private int index;

    public RLEIterator(int[] encoded) {
        this.encoding = encoded;
        this.index = 0;
    }
    
    public int next(int n) {
        while (index < encoding.length && n > 0) {
            if (encoding[index] >= n) {
                encoding[index] -= n;
                return encoding[index + 1];
            } else {
                n -= encoding[index];
                index += 2;
            }
        }
        return -1;
    }
}
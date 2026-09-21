// ──────────────────────────────────────────────────
// Problem  : 384. Shuffle an Array
// Difficulty: Medium
// Tags     : Array, Math, Design, Randomized
// Link     : https://leetcode.com/problems/shuffle-an-array/
// Runtime  : 57 ms (beats 12%)
// Memory   : 52828000 (beats 9%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private int[] original;
    private int[] array;
    private Random rand;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.array = nums.clone();
        this.rand = new Random();
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
           
            int j = i + rand.nextInt(array.length - i);
            swap(i, j);
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


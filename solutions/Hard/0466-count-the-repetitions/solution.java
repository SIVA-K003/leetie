// ──────────────────────────────────────────────────
// Problem  : 466. Count The Repetitions
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming
// Link     : https://leetcode.com/problems/count-the-repetitions/
// Runtime  : 5 ms (beats 24%)
// Memory   : 96896000 (beats 6%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int len1 = c1.length, len2 = c2.length;
        int count1 = 0, count2 = 0, index = 0;
        
        int[] repeatCount = new int[n1 + 1];
        int[] nextIndex = new int[n1 + 1];
        
        while (count1 < n1) {
            count1++;
            for (int i = 0; i < len1; i++) {
                if (c1[i] == c2[index]) {
                    index++;
                    if (index == len2) {
                        index = 0;
                        count2++;
                    }
                }
            }
            repeatCount[count1] = count2;
            nextIndex[count1] = index;
            
            for (int start = 0; start < count1; start++) {
                if (nextIndex[start] == index) {
                    int prevCount1 = start;
                    int prevCount2 = repeatCount[start];
                    
                    int patternCount1 = count1 - prevCount1;
                    int patternCount2 = count2 - prevCount2;
                    
                    int remainingLoops = (n1 - prevCount1) % patternCount1;
                    int totalRepeats = prevCount2 + 
                                     (n1 - prevCount1) / patternCount1 * patternCount2 + 
                                     repeatCount[prevCount1 + remainingLoops] - prevCount2;
                    
                    return totalRepeats / n2;
                }
            }
        }
        
        return repeatCount[n1] / n2;
    }
}
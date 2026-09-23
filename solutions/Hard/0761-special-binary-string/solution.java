// ──────────────────────────────────────────────────
// Problem  : 761. Special Binary String
// Difficulty: Hard
// Tags     : String, Divide and Conquer, Sorting
// Link     : https://leetcode.com/problems/special-binary-string/
// Runtime  : 3 ms (beats 58%)
// Memory   : 43520000 (beats 7%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }

           
            if (count == 0) {
                
                String inner = s.substring(i + 1, j);
                list.add("1" + makeLargestSpecial(inner) + "0");
                i = j + 1;
            }
        }

       
        Collections.sort(list, Collections.reverseOrder());

        return String.join("", list);
    }
}
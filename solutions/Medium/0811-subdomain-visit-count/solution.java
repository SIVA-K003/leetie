// ──────────────────────────────────────────────────
// Problem  : 811. Subdomain Visit Count
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Counting
// Link     : https://leetcode.com/problems/subdomain-visit-count/
// Runtime  : 15 ms (beats 75%)
// Memory   : 52776000 (beats 81%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();

        for (String domain : cpdomains) {
           
            int spaceIdx = domain.indexOf(' ');
            int count = Integer.parseInt(domain.substring(0, spaceIdx));
            String sub = domain.substring(spaceIdx + 1);

           
            while (!sub.isEmpty()) {
                counts.put(sub, counts.getOrDefault(sub, 0) + count);
                int dotIdx = sub.indexOf('.');
                if (dotIdx == -1) {
                    break;
                }
                sub = sub.substring(dotIdx + 1);
            }
        }

        
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
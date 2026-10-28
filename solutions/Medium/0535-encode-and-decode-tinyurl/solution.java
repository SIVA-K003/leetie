// ──────────────────────────────────────────────────
// Problem  : 535. Encode and Decode TinyURL
// Difficulty: Medium
// Tags     : Hash Table, String, Design, Hash Function
// Link     : https://leetcode.com/problems/encode-and-decode-tinyurl/
// Runtime  : 6 ms (beats 14%)
// Memory   : 43956000 (beats 86%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private int id = 0;

    
    public String encode(String longUrl) {
        map.put(++id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    
    public String decode(String shortUrl) {
        int id = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(id);
    }
}
// ──────────────────────────────────────────────────
// Problem  : 460. LFU Cache
// Difficulty: Hard
// Tags     : Hash Table, Linked List, Design, Doubly-Linked List
// Link     : https://leetcode.com/problems/lfu-cache/
// Runtime  : 62 ms (beats 44%)
// Memory   : 136768000 (beats 47%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    
    private static class Node {
        int key, value, freq;
        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyNodeMap;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) return -1;
        Node node = keyNodeMap.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        
        if (keyNodeMap.size() >= capacity) {
            // Evict LFU (and LRU tie-breaker) from minFreq list
            LinkedHashSet<Integer> minFreqKeys = freqMap.get(minFreq);
            int evictKey = minFreqKeys.iterator().next();
            minFreqKeys.remove(evictKey);
            if (minFreqKeys.isEmpty()) {
                freqMap.remove(minFreq);
            }
            keyNodeMap.remove(evictKey);
        }
        
        Node newNode = new Node(key, value, 1);
        keyNodeMap.put(key, newNode);
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
    
    private void updateFreq(Node node) {
        int freq = node.freq;
        LinkedHashSet<Integer> keys = freqMap.get(freq);
        keys.remove(node.key);
        
        if (freq == minFreq && keys.isEmpty()) {
            minFreq++;
        }
        
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node.key);
    }
}
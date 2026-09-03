// ──────────────────────────────────────────────────
// Problem  : 705. Design HashSet
// Difficulty: Easy
// Tags     : Array, Hash Table, Linked List, Design, Hash Function
// Link     : https://leetcode.com/problems/design-hashset/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42424000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.LinkedList;

class MyHashSet {
    private final int SIZE = 769; // A prime number to minimize collisions
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}
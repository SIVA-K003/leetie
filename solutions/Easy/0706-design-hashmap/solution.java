// ──────────────────────────────────────────────────
// Problem  : 706. Design HashMap
// Difficulty: Easy
// Tags     : Array, Hash Table, Linked List, Design, Hash Function
// Link     : https://leetcode.com/problems/design-hashmap/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42708000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.LinkedList;

class MyHashMap {
    private class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 769; // A prime number to reduce collisions
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key == key) {
                node.value = value; // Update existing key
                return;
            }
        }
        buckets[index].add(new Node(key, value)); // Insert new key-value pair
    }
    
    public int get(int key) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node target = null;
        for (Node node : buckets[index]) {
            if (node.key == key) {
                target = node;
                break;
            }
        }
        if (target != null) {
            buckets[index].remove(target);
        }
    }
}
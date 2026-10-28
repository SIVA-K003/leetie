// ──────────────────────────────────────────────────
// Problem  : 432. All O`one Data Structure
// Difficulty: Hard
// Tags     : Hash Table, Linked List, Design, Doubly-Linked List
// Link     : https://leetcode.com/problems/all-oone-data-structure/
// Runtime  : 77 ms (beats 69%)
// Memory   : 78320000 (beats 92%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    
    // Node representing a bucket of keys with the same count/frequency
    private static class Node {
        int count;
        Set<String> keys = new HashSet<>();
        Node prev;
        Node next;
        
        Node(int count) {
            this.count = count;
        }
    }
    
    private Node head; // Dummy head (points to min frequency)
    private Node tail; // Dummy tail (points to max frequency)
    
    // Map from key to its corresponding bucket node
    private Map<String, Node> keyNodeMap;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        keyNodeMap = new HashMap<>();
    }
    
    public void inc(String key) {
        if (!keyNodeMap.containsKey(key)) {
            // If key doesn't exist, it belongs to frequency 1
            if (head.next == tail || head.next.count > 1) {
                addNodeAfter(head, new Node(1));
            }
            head.next.keys.add(key);
            keyNodeMap.put(key, head.next);
        } else {
            // If key exists, move it to a bucket with count + 1
            Node curNode = keyNodeMap.get(key);
            int targetCount = curNode.count + 1;
            Node nextNode = curNode.next;
            
            if (nextNode == tail || nextNode.count > targetCount) {
                addNodeAfter(curNode, new Node(targetCount));
            }
            
            curNode.next.keys.add(key);
            keyNodeMap.put(key, curNode.next);
            
            // Clean up old bucket if empty
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }
    
    public void dec(String key) {
        Node curNode = keyNodeMap.get(key);
        int targetCount = curNode.count - 1;
        
        if (targetCount == 0) {
            keyNodeMap.remove(key);
        } else {
            Node prevNode = curNode.prev;
            if (prevNode == head || prevNode.count < targetCount) {
                addNodeAfter(prevNode, new Node(targetCount));
            }
            curNode.prev.keys.add(key);
            keyNodeMap.put(key, curNode.prev);
        }
        
        curNode.keys.remove(key);
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) return "";
        
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) return "";
       
        return head.next.keys.iterator().next();
    }
    
    
    private void addNodeAfter(Node node, Node newNode) {
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
    }
    
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
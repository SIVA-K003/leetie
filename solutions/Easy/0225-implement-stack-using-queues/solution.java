// ──────────────────────────────────────────────────
// Problem  : 225. Implement Stack using Queues
// Difficulty: Easy
// Tags     : Stack, Design, Queue
// Link     : https://leetcode.com/problems/implement-stack-using-queues/
// Runtime  : 2 ms (beats 29%)
// Memory   : 42348000 (beats 98%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
       
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }
    
  
    public int pop() {
        return queue.remove();
    }
    
    
    public int top() {
        return queue.peek();
    }
    
   
    public boolean empty() {
        return queue.isEmpty();
    }
}
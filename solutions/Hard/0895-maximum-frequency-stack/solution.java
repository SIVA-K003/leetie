// ──────────────────────────────────────────────────
// Problem  : 895. Maximum Frequency Stack
// Difficulty: Hard
// Tags     : Hash Table, Stack, Design, Ordered Set
// Link     : https://leetcode.com/problems/maximum-frequency-stack/
// Runtime  : 34 ms (beats 48%)
// Memory   : 72692000 (beats 38%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        // 1. Increment frequency of the element
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        
        // 2. Update maxFreq if this frequency exceeds it
        if (f > maxFreq) {
            maxFreq = f;
        }
        
        // 3. Push element into the stack corresponding to its frequency level
        group.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        // 1. Retrieve the most frequent element from the maxFreq stack
        Stack<Integer> maxFreqStack = group.get(maxFreq);
        int x = maxFreqStack.pop();
        
        // 2. Decrease its frequency in the map
        freq.put(x, freq.get(x) - 1);
        
        // 3. If the current frequency stack becomes empty, decrement maxFreq
        if (maxFreqStack.isEmpty()) {
            maxFreq--;
        }
        
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
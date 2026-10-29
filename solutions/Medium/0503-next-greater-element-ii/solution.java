// ──────────────────────────────────────────────────
// Problem  : 503. Next Greater Element II
// Difficulty: Medium
// Tags     : Array, Stack, Monotonic Stack
// Link     : https://leetcode.com/problems/next-greater-element-ii/
// Runtime  : 17 ms (beats 22%)
// Memory   : 48312000 (beats 59%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        // Traverse twice to simulate the circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentIndex = i % n;
            
            // Pop elements that are not greater than the current element
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[currentIndex]) {
                stack.pop();
            }
            
            // If the stack is not empty, the top element is the next greater number
            if (!stack.isEmpty()) {
                result[currentIndex] = nums[stack.peek()];
            }
            
            // Push the current index onto the stack
            stack.push(currentIndex);
        }
        
        return result;
    }
}
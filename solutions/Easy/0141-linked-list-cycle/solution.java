// ──────────────────────────────────────────────────
// Problem  : 141. Linked List Cycle
// Difficulty: Easy
// Tags     : Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/linked-list-cycle/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46324000 (beats 96%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
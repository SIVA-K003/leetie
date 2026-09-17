// ──────────────────────────────────────────────────
// Problem  : 142. Linked List Cycle II
// Difficulty: Medium
// Tags     : Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/linked-list-cycle-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46400000 (beats 93%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Determine if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find the start node of the cycle
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null;
    }
}
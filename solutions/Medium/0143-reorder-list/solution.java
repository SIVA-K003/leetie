// ──────────────────────────────────────────────────
// Problem  : 143. Reorder List
// Difficulty: Medium
// Tags     : Linked List, Two Pointers, Stack, Recursion
// Link     : https://leetcode.com/problems/reorder-list/
// Runtime  : 2 ms (beats 86%)
// Memory   : 49336000 (beats 37%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list starting from slow.next
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Split the list into two halves

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Merge the two halves alternately
        ListNode first = head;
        ListNode second = prev; // Head of the reversed second half

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
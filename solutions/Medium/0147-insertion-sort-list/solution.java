// ──────────────────────────────────────────────────
// Problem  : 147. Insertion Sort List
// Difficulty: Medium
// Tags     : Linked List, Sorting
// Link     : https://leetcode.com/problems/insertion-sort-list/
// Runtime  : 21 ms (beats 8%)
// Memory   : 46628000 (beats 6%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = head;       

        while (curr != null) {
            ListNode nextTemp = curr.next; 
            ListNode prev = dummy;          
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

           
            curr.next = prev.next;
            prev.next = curr;

           
            curr = nextTemp;
        }

        return dummy.next;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
// Difficulty: Medium
// Tags     : Linked List
// Link     : https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
// Runtime  : 4 ms (beats 100%)
// Memory   : 106080000 (beats 70%)
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            // Check if current node is a local maxima or local minima
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {
                
                if (firstIndex == -1) {
                    firstIndex = index;
                } else {
                    minDistance = Math.min(minDistance, index - prevIndex);
                }
                
                prevIndex = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // If fewer than 2 critical points were found
        if (firstIndex == -1 || prevIndex == firstIndex) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
    }
}
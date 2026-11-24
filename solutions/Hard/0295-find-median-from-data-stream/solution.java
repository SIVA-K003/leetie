// ──────────────────────────────────────────────────
// Problem  : 295. Find Median from Data Stream
// Difficulty: Hard
// Tags     : Two Pointers, Design, Sorting, Heap (Priority Queue), Data Stream
// Link     : https://leetcode.com/problems/find-median-from-data-stream/
// Runtime  : 223 ms (beats 14%)
// Memory   : 110896000 (beats 82%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private final PriorityQueue<Integer> maxHeap; // Lower half (max at root)
    private final PriorityQueue<Integer> minHeap; // Upper half (min at root)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
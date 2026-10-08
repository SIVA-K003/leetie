// ──────────────────────────────────────────────────
// Problem  : 218. The Skyline Problem
// Difficulty: Hard
// Tags     : Array, Divide and Conquer, Binary Indexed Tree, Segment Tree, Sweep Line, Sorting, Heap (Priority Queue), Ordered Set
// Link     : https://leetcode.com/problems/the-skyline-problem/
// Runtime  : 29 ms (beats 69%)
// Memory   : 53188000 (beats 94%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> points = new ArrayList<>();

        // Process each building into two events (left and right edges)
        for (int[] b : buildings) {
            // Left edge has negative height to distinguish from right edge
            // and ensure correct sorting order for same x-coordinates.
            points.add(new int[]{b[0], -b[2]});
            points.add(new int[]{b[1], b[2]});
        }

        // Sort events:
        // 1. By x-coordinate ascending
        // 2. If x is same, sort by height ascending (negative height first)
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

       
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0);

        
        Map<Integer, Integer> removeMap = new HashMap<>();
        int prevMaxHeight = 0;

        for (int[] p : points) {
            int x = p[0];
            int h = p[1];

            if (h < 0) {
              
                maxHeap.add(-h);
            } else {
               
                removeMap.put(h, removeMap.getOrDefault(h, 0) + 1);
            }

           
            while (!maxHeap.isEmpty() && removeMap.getOrDefault(maxHeap.peek(), 0) > 0) {
                int top = maxHeap.peek();
                removeMap.put(top, removeMap.get(top) - 1);
                maxHeap.poll();
            }

            int currentMaxHeight = maxHeap.peek();
            
           
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}
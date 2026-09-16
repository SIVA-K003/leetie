// ──────────────────────────────────────────────────
// Problem  : 210. Course Schedule II
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
// Link     : https://leetcode.com/problems/course-schedule-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42756000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list and calculate in-degrees
        for (int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        // Add courses with zero prerequisites to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        // Process topological ordering via BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Return order if all courses could be processed, else an empty array
        return index == numCourses ? order : new int[0];
    }
}
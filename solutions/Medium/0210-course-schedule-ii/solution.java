// ──────────────────────────────────────────────────
// Problem  : 210. Course Schedule II
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
// Link     : https://leetcode.com/problems/course-schedule-ii/
// Runtime  : 5 ms (beats 80%)
// Memory   : 46608000 (beats 81%)
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

        
        for (int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        
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

        
        return index == numCourses ? order : new int[0];
    }
}
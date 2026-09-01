// ──────────────────────────────────────────────────
// Problem  : 3568. Minimum Moves to Clean the Classroom
// Difficulty: Medium
// Tags     : Array, Hash Table, Bit Manipulation, Breadth-First Search, Matrix
// Link     : https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/
// Runtime  : 107 ms (beats 95%)
// Memory   : 55888000 (beats 95%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    private record State(int r, int c, int mask, int energy, int steps) {}

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startR = -1, startC = -1;
        
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }
        
        int litterCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterIndex[r][c] = litterCount++;
                }
            }
        }
        
        int targetMask = (1 << litterCount) - 1;
        
        // Queue for BFS: (r, c, mask, energy, steps)
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(startR, startC, 0, energy, 0));
        
        // bestEnergy[r][c][mask] stores the max remaining energy seen for state (r, c, mask)
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int[][] mat : bestEnergy) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        bestEnergy[startR][startC][0] = energy;
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            
            if (curr.mask == targetMask) {
                return curr.steps;
            }
            
            if (curr.energy == 0) {
                continue;
            }
            
            for (int[] d : dirs) {
                int nr = curr.r + d[0];
                int nc = curr.c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    char cell = classroom[nr].charAt(nc);
                    int nextMask = curr.mask;
                    int nextEnergy = curr.energy - 1;
                    
                    if (cell == 'L') {
                        nextMask |= (1 << litterIndex[nr][nc]);
                    } else if (cell == 'R') {
                        nextEnergy = energy; // Reset to full capacity
                    }
                    
                    if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                        bestEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new State(nr, nc, nextMask, nextEnergy, curr.steps + 1));
                    }
                }
            }
        }
        
        return -1;
    }
}
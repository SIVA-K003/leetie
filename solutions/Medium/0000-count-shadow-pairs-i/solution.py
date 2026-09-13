# ──────────────────────────────────────────────────
# Problem  : 0. Count Shadow Pairs I
# Difficulty: Medium
# Tags     : N/A
# Link     : https://leetcode.com/problems/count-shadow-pairs-i/
# Runtime  : 0 ms (beats 0%)
# Memory   : 19564000 (beats 0%)
# Language : python3
# Copyright: (c) 2026 SIVA-K003. All rights reserved.
# Synced by: leetie
# ──────────────────────────────────────────────────

class Solution:
    def shadowPairs(self, nums):
        count = 0
        stack = []  # Stores elements in non-increasing order
        
        for x in nums:
            # x forms a valid shadow pair with every element strictly smaller than x
            while stack and stack[-1] < x:
                stack.pop()
                count += 1
                
            # Equal elements block smaller elements behind them from x,
            # but cannot pair with x (since nums[i] < nums[j] is required)
            while stack and stack[-1] == x:
                stack.pop()
                
            stack.append(x)
            
        return count
[3,1,4,1,5]
[6,7,6,6,7]
[1,2,3,4]
4
2
3
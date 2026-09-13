# ──────────────────────────────────────────────────
# Problem  : 4344. Minimum Operations to Make Every Element Palindromic
# Difficulty: Medium
# Tags     : N/A
# Link     : https://leetcode.com/problems/minimum-operations-to-make-every-element-palindromic/
# Runtime  : 575 ms (beats 20%)
# Memory   : 46880000 (beats 0%)
# Language : python3
# Copyright: (c) 2026 SIVA-K003. All rights reserved.
# Synced by: leetie
# ──────────────────────────────────────────────────

class Solution:
    _evens = []
    _odds = []
    for length in range(1, 11):
        half_len = (length + 1) // 2
        start = 10 ** (half_len - 1) if half_len > 1 else 1
        end = 10 ** half_len
        for prefix in range(start, end):
            s = str(prefix)
            if length % 2 == 0:
                pal = int(s + s[::-1])
            else:
                pal = int(s + s[:-1][::-1])
            if pal % 2 == 0:
                _evens.append(pal)
            else:
                _odds.append(pal)
    _evens = sorted(list(set(_evens)))
    _odds = sorted(list(set(_odds)))

    def minOperations(self, nums: list[int]) -> int:
        import bisect
        
        total_ops = 0
        for x in nums:
            target_list = Solution._evens if x % 2 == 0 else Solution._odds
            idx = bisect.bisect_left(target_list, x)
            
            min_op = float('inf')
            if idx < len(target_list):
                min_op = min(min_op, abs(target_list[idx] - x) // 2)
            if idx > 0:
                min_op = min(min_op, abs(target_list[idx - 1] - x) // 2)
                
            total_ops += min_op
            
        return total_ops
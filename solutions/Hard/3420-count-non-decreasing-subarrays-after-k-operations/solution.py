# ──────────────────────────────────────────────────
# Problem  : 3420. Count Non-Decreasing Subarrays After K Operations
# Difficulty: Hard
# Tags     : Array, Stack, Segment Tree, Queue, Sliding Window, Monotonic Stack, Monotonic Queue
# Link     : https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
# Runtime  : 303 ms (beats 77%)
# Memory   : 36672000 (beats 100%)
# Language : python3
# Copyright: (c) 2026 SIVA-K003. All rights reserved.
# Synced by: leetie
# ──────────────────────────────────────────────────

from collections import deque
from typing import List

class Solution:
    def countNonDecreasingSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dq = deque()
        cost = 0
        ans = 0
        j = n - 1

        for i in range(n - 1, -1, -1):

            while dq and nums[dq[-1]] < nums[i]:
                l = dq.pop()
                r = dq[-1] if dq else j + 1

                cost += (r - l) * (nums[i] - nums[l])

            dq.append(i)

            while cost > k:
                cost -= nums[dq[0]] - nums[j]

                if dq[0] == j:
                    dq.popleft()

                j -= 1

            ans += j - i + 1

        return ans
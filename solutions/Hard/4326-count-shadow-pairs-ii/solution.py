# ──────────────────────────────────────────────────
# Problem  : 4326. Count Shadow Pairs II
# Difficulty: Hard
# Tags     : N/A
# Link     : https://leetcode.com/problems/count-shadow-pairs-ii/
# Runtime  : 9030 ms (beats 33%)
# Memory   : 28300000 (beats 100%)
# Language : python3
# Copyright: (c) 2026 SIVA-K003. All rights reserved.
# Synced by: leetie
# ──────────────────────────────────────────────────

            sorted_block[b] = sorted(arr[b])

        def query_prefix(end, x):
            if end <= 0:
                return 0

            full = end // B
            rem = end % B
            ans = 0

            # Complete blocks
            for b in range(full):
                if lazy[b] >= x:
                    s = sorted_block[b]
                    ans += len(s) - bisect_left(s, x)

            # Partial block
            if rem:
                b = full
                push(b)

                a = arr[b]

                for i in range(rem):
                    if a[i] >= x:
                        ans += 1

            return ans

        def chmin_prefix(end, x):
            if end <= 0:
                return

            full = end // B
            rem = end % B

            # Complete blocks
            for b in range(full):
                if lazy[b] > x:
                    lazy[b] = x

            # Partial block
            if rem:
                b = full
                push(b)

                a = arr[b]

                for i in range(rem):
                    if a[i] > x:
                        a[i] = x

                rebuild(b)

        ans = 0

        for j, x in enumerate(nums):

            
            boundary = first[x]
            
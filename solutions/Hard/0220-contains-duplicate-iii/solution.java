// ──────────────────────────────────────────────────
// Problem  : 220. Contains Duplicate III
// Difficulty: Hard
// Tags     : Array, Sliding Window, Sorting, Bucket Sort, Ordered Set
// Link     : https://leetcode.com/problems/contains-duplicate-iii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42668000 (beats 0%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff < 1 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        long width = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i];
            long bucketId = getBucketId(val, width);

            // Check if current bucket already has a matching element
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Check neighboring buckets
            if (buckets.containsKey(bucketId - 1) && Math.abs(val - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }
            if (buckets.containsKey(bucketId + 1) && Math.abs(val - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Insert current value into its bucket
            buckets.put(bucketId, val);

            // Maintain sliding window of size indexDiff
            if (i >= indexDiff) {
                long oldBucketId = getBucketId((long) nums[i - indexDiff], width);
                buckets.remove(oldBucketId);
            }
        }

        return false;
    }

    private long getBucketId(long val, long width) {
        // Adjust negative numbers so they map correctly to negative bucket indices
        return val < 0 ? (val + 1) / width - 1 : val / width;
    }
}
-- ──────────────────────────────────────────────────
-- Problem  : 180. Consecutive Numbers
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/consecutive-numbers/
-- Runtime  : 70 ms (beats 0%)
-- Memory   : 0B (beats 0%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
JOIN Logs l2 ON l1.id = l2.id - 1 AND l1.num = l2.num
JOIN Logs l3 ON l1.id = l3.id - 2 AND l1.num = l3.num;
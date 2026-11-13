-- ──────────────────────────────────────────────────
-- Problem  : 178. Rank Scores
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/rank-scores/
-- Runtime  : 76 ms (beats 0%)
-- Memory   : 0B (beats 0%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT 
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
FROM Scores
ORDER BY score DESC;
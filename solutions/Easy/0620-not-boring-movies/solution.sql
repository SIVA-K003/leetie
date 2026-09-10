-- ──────────────────────────────────────────────────
-- Problem  : 620. Not Boring Movies
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/not-boring-movies/
-- Runtime  : 288 ms (beats 54%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below

SELECT *
FROM cinema c
WHERE c.id % 2 =1 
    AND 
    c.description != 'boring'
ORDER BY c.rating DESC;
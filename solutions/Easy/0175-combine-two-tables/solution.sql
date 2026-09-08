-- ──────────────────────────────────────────────────
-- Problem  : 175. Combine Two Tables
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/combine-two-tables/
-- Runtime  : 393 ms (beats 92%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT 
    p.firstName, 
    p.lastName, 
    a.city, 
    a.state
FROM Person p
LEFT JOIN Address a 
    ON p.personId = a.personId;
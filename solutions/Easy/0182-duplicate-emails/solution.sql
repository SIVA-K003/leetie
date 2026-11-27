-- ──────────────────────────────────────────────────
-- Problem  : 182. Duplicate Emails
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/duplicate-emails/
-- Runtime  : 318 ms (beats 96%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;
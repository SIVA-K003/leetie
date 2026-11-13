-- ──────────────────────────────────────────────────
-- Problem  : 181. Employees Earning More Than Their Managers
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/employees-earning-more-than-their-managers/
-- Runtime  : 400 ms (beats 69%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT e1.name AS Employee
FROM Employee e1
JOIN Employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;
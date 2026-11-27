-- ──────────────────────────────────────────────────
-- Problem  : 185. Department Top Three Salaries
-- Difficulty: Hard
-- Tags     : Database
-- Link     : https://leetcode.com/problems/department-top-three-salaries/
-- Runtime  : 802 ms (beats 95%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH RankedSalaries AS (
    SELECT
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER (
            PARTITION BY e.departmentId
            ORDER BY e.salary DESC
        ) AS rnk
    FROM Employee e
    JOIN Department d
        ON e.departmentId = d.id
)
SELECT
    Department,
    Employee,
    Salary
FROM RankedSalaries
WHERE rnk <= 3;
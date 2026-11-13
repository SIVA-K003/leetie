-- ──────────────────────────────────────────────────
-- Problem  : 177. Nth Highest Salary
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/nth-highest-salary/
-- Runtime  : 618 ms (beats 22%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  -- Adjust N to account for OFFSET (N - 1)
  SET N = N - 1;
  
  RETURN (
      SELECT DISTINCT salary 
      FROM Employee 
      ORDER BY salary DESC 
      LIMIT 1 OFFSET N
  );
END;
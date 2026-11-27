-- ──────────────────────────────────────────────────
-- Problem  : 183. Customers Who Never Order
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/customers-who-never-order/
-- Runtime  : 519 ms (beats 87%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 SIVA-K003. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o
    ON c.id = o.customerId
WHERE o.customerId IS NULL;
/* Write your T-SQL query statement below */
SELECT
    e1.name
FROM Employee as e1
INNER JOIN Employee as e2
ON e1.id = e2.managerId
GROUP BY e2.managerId, e1.name
HAVING COUNT(e2.managerId) >= 5
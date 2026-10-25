/* Write your T-SQL query statement below */

SELECT
    t.employee_id,
    t.name,
    COUNT(t.employee_id) as reports_count,
    CAST(ROUND(AVG(t.age * 1.0), 0) AS INT) as average_age
FROM 
(
    SELECT
        e1.employee_id,
        e1.name,
        e2.age
    FROM Employees e1
    LEFT JOIN Employees e2
    ON e1.employee_id = e2.reports_to
    WHERE e2.employee_id IS NOT NULL
) as t
GROUP BY t.employee_id, t.name
order by t.employee_id

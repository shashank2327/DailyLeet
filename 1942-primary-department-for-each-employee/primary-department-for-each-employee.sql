/* Write your T-SQL query statement below */

SELECT
    t.employee_id,
    t.department_id
FROM
(
    SELECT
        *,
        COUNT(employee_id) OVER (Partition BY employee_id) as cnt
    FROM Employee
) as t
WHERE t.cnt = 1 OR t.primary_flag = 'Y'
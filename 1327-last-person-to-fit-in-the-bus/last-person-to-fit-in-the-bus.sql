/* Write your T-SQL query statement below */

SELECT TOP 1
    person_name
FROM (
    SELECT
        *,
        SUM(weight) OVER (ORDER BY turn ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS curr_weight_sum
    FROM Queue
) as T
WHERE 
    curr_weight_sum <= 1000
ORDER BY curr_weight_sum DESC

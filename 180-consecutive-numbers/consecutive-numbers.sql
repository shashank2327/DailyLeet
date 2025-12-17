/* Write your T-SQL query statement below */
SELECT
    DISTINCT num as ConsecutiveNums
FROM (
    SELECT
        id,
        num,
        LAG(num,1, 0) OVER(ORDER BY id) AS one_prev_num,
        LAG(num, 2, 0) OVER(ORDER BY id) AS two_prev_num
    FROM Logs
) AS t
WHERE 
    num = one_prev_num
    AND
    num = two_prev_num
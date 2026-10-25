/* Write your T-SQL query statement below */

SELECT
    MAX(t.num) as num
FROM
(
    SELECT
        num,
        COUNT(num) as cnt
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
) t
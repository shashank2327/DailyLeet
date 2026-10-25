/* Write your T-SQL query statement below */

SELECT
    c2.class
FROM
(
    SELECT
        c1.class as class,
        COUNT(c1.student) as cnt
    FROM Courses  as c1
    GROUP BY c1.class
) as c2
WHERE c2.cnt >= 5
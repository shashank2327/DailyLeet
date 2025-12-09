/* Write your T-SQL query statement below */
SELECT
    w1.id
FROM Weather AS w1
LEFT JOIN Weather AS w2
ON DATEDIFF(day, w2.recordDate, w1.recordDate) = 1
WHERE w1.temperature > w2.temperature
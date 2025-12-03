/* Write your T-SQL query statement below */
SELECT 
    *
FROM Cinema as c
WHERE c.description != 'boring' AND c.id % 2 = 1
ORDER BY c.rating DESC
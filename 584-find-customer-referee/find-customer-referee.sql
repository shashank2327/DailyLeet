/* Write your T-SQL query statement below */
SELECT 
    c.name
FROM Customer AS c
WHERE  referee_id IS NULL 
    or referee_id != 2
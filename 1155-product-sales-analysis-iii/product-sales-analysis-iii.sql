/* Write your T-SQL query statement below */

SELECT
    s2.product_id,
    s2.year as first_year,
    s2.quantity,
    s2.price
FROM (
    SELECT
        *,
        MIN(s1.year) OVER (Partition by s1.product_id) as min_year
    FROM Sales as s1
) as s2

WHERE s2.year = s2.min_year

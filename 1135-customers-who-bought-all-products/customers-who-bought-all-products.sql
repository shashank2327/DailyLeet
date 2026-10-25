/* Write your T-SQL query statement below */
-- SELECT
--     COUNT(*)
-- FROM Product


SELECT
    t.customer_id as customer_id
FROM 
(
    SELECT 
        customer_id,
        COUNT(DISTINCT(product_key)) as cnt
    FROM Customer
    Group BY customer_id
) as t
WHERE t.cnt = (SELECT COUNT(*) FROM Product)
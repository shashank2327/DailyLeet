/* Write your T-SQL query statement below */

SELECT
    t.month as month,
    t.country as country,
    COUNT(*) as trans_count,
    SUM(success) as approved_count,
    SUM(amount) as trans_total_amount,
    SUM(amount * success) as approved_total_amount
FROM 
    (SELECT
        *,
        LEFT(trans_date, 7) as month,
        CASE
            WHEN state = 'approved' THEN 1
            ELSE 0
        END as success
    FROM Transactions) as t
GROUP BY t.month, t.country
order by t.country desc

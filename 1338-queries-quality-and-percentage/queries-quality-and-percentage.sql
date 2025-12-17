/* Write your T-SQL query statement below */

SELECT
    query_name,
    ROUND(AVG(qualityRatio), 2) AS quality,
    ROUND(AVG(CAST(ratingFix AS FLOAT)) * 100, 2) AS poor_query_percentage
FROM (
    SELECT
        query_name,
        CAST(rating AS FLOAT) / position AS qualityRatio,
        CASE
            WHEN rating < 3 THEN 1
            ELSE 0
        END AS ratingFix
    FROM Queries
) as T 
WHERE query_name IS NOT NULL
GROUP BY query_name
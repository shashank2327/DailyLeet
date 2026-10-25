/* Write your T-SQL query statement below */


SELECT
    user_id,
    COUNT(f1.follower_id) AS followers_count
FROM Followers as f1
GROUP BY user_id
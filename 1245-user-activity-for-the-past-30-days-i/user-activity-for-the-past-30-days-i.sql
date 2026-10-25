/* Write your T-SQL query statement below */

/*
    daily how many users were active;
*/

SELECT
    activity_date as day,
    COUNT(Distinct(user_id)) as active_users
FROM Activity
WHERE datediff(day, activity_date, '2019-07-27') < 30 AND datediff(day, activity_date, '2019-07-27') >= 0
GROUP BY activity_date
ORDER BY activity_date
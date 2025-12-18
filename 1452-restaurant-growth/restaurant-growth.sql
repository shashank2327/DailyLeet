/* Write your T-SQL query statement below */

select
    visited_on,
    sum(amount) over(order by visited_on rows between 6 preceding and current row) as amount,
    round(avg(cast (amount as float)) over(order by visited_on rows between 6 preceding and current row),2) as average_amount
from (
    select 
        visited_on , 
        sum(amount) as amount 
    from Customer 
    group by visited_on
) t
order by visited_on offset 6 rows;
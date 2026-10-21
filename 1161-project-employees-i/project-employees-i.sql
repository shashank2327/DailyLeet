# Write your MySQL query statement below
select
    p.project_id,
    ROUND(SUM(e.experience_years) * 1.0 / NULLIF(COUNT(*), 0), 2) as average_years
from Project p
Left join Employee e
ON e.employee_id = p.employee_id
group by p.project_id
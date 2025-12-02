/* Write your T-SQL query statement below */
SELECT
    emu.unique_id,
    em.name
FROM Employees as em
LEFT JOIN EmployeeUNI as emu
ON em.id = emu.id
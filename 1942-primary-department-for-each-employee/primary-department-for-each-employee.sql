# Write your MySQL query statement below
WITH rankTable AS (
    SELECT 
    employee_id,
    department_id,
    primary_flag,
    COUNT(*) OVER(PARTITION BY employee_id) as freq
    from Employee

)
SELECT
employee_id,
department_id
from rankTable
WHERE (freq = 1) 
      OR (freq>1 AND primary_flag='Y');
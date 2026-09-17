# Write your MySQL query statement below
SELECT
e1.employee_id,
e1.department_id
from Employee e1
WHERE 1=(
    SELECT COUNT(*)
    FROM Employee e2
    WHERE e1.employee_id = e2.employee_id
) OR e1.primary_flag='Y';
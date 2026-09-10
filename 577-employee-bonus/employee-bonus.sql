# Write your MySQL query statement below
SELECT e.name, b.bonus
from Employee as e
LEFT JOIN
Bonus as b
on e.empId = b.empId
WHERE b.empId IS NULL
OR b.bonus<1000 

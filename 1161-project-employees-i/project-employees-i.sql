# Write your MySQL query statement below
select p.project_id,
ROUND(AVG(e.experience_years),2) as average_years
FROM Project as p
JOIN 
Employee as e
on p.employee_id = e.employee_id
GROUP BY
p.project_id;

# Write your MySQL query statement below
SELECT query_name,
ROUND(AVG(rating*1.0/position),2) as quality,
ROUND(
    100*SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END)
    /COUNT(*),2
) as poor_query_percentage
from Queries 
GROUP BY query_name;

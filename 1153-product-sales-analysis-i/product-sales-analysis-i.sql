# Write your MySQL query statement be
SELECT p.product_name, s.year, s.price
FROM Sales as s
LEFT JOIN 
Product as p
on s.product_id = p.product_id;
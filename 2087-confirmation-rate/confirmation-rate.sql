# Write your MySQL query statement below
select s.user_id, ROUND(AVG(if(c.action="confirmed",1,0)),2) as confirmation_rate
FROM Signups as s
LEFT JOIN Confirmations as c
ON s.user_id = c.user_id
GROUP BY s.user_id

-- # Write your MySQL query statement below
-- select s.user_id, round(avg(if(c.action="confirmed",1,0)),2) as confirmation_rate
-- from Signups as s left join Confirmations as c on s.user_id= c.user_id group by user_id;


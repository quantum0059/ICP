# Write your MySQL query statement below
WITH first_login AS (
    SELECT
    player_id,
    MIN(event_date) as min_date
    from Activity
    GROUP BY player_id
)
Select
ROUND(
    COUNT(DISTINCT a.player_id)*1.0/(SELECT COUNT(*) FROM first_login),2
) as fraction
FROM Activity as a
JOIN
first_login as f
on a.player_id = f.player_id
AND DATEDIFF(a.event_date, f.min_date)=1;

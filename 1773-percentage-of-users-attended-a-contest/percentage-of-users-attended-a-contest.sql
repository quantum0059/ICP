# Write your MySQL query statement below
select
     r.contest_id,
    ROUND(
        COUNT(DISTINCT r.user_id) * 100.0 /
        (SELECT COUNT(*) FROM Users),
        2
    ) AS percentage
FROM Register as r
GROUP BY
    r.contest_id
ORDER BY percentage DESC, contest_id ASC;

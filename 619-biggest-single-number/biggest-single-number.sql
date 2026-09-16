# Write your MySQL query statement below
WITH Freq AS (
    SELECT
       num,
       COUNT(*) as frequency
       FROM MyNumbers
       GROUP BY num
)
SELECT MAX(num) as num
FROM Freq
WHERE frequency = 1;

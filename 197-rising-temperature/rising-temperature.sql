# Write your MySQL query statement below
-- SELECT today.id
-- FROM Weather as today
-- CROSS JOIN 
-- Weather as yesterday
-- on DATEDIFF(today.recordDate, yesterday.recordDate) = 1
-- AND today.temperature > yesterday.temperature;
SELECT id
FROM Weather AS today
WHERE temperature > (
    SELECT yesterday.temperature
    FROM Weather AS yesterday
    WHERE DATEDIFF(today.recordDate, yesterday.recordDate) = 1
);
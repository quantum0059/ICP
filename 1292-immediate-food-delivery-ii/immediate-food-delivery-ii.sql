# Write your MySQL query statement below
Select
ROUND(
    Sum(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 OR 0 END)*100/ COUNT(d.customer_id),2
) as immediate_percentage
FROM Delivery AS d
WHERE (d.customer_id, d.order_date) IN (
    SELECT
       customer_id,
       MIN(order_date) AS ORDER_DATE
    FROM Delivery
    GROUP BY customer_id
);


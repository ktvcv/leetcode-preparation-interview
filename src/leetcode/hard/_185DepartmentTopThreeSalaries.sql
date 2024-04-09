# Write your MySQL query statement below
# Write your MySQL query statement below
WITH cte AS ( SELECT e.id as employee1,
     DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rk
FROM Employee e
)
SELECT  d.name Department, e.name Employee, e.salary Salary
FROM Employee e
         JOIN Department d ON d.id = e.departmentId
         JOIn CTE c ON c.employee1 = e.id AND  c.rk IN (1,2,3)
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT ranked_salary.s FROM
        (SELECT 
          salary as s,
          dense_rank() over (ORDER BY salary DESC) as r
        FROM Employee) 
      AS ranked_salary
      WHERE ranked_salary.r = N
      LIMIT 1
  );
END
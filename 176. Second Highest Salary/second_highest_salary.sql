    (
        SELECT ranked_salary.s AS secondhighestsalary
        FROM   ( SELECT  salary AS s, Dense_rank() over (ORDER BY salary DESC) AS r FROM employee ) AS ranked_salary
        WHERE  ranked_salary.r = 2
    )
UNION
    (SELECT NULL)
LIMIT  1;
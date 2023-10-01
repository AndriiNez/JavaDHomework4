SELECT c.NAME, COUNT(p.ID) AS PROJECT_COUNT
FROM client c
LEFT JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.NAME
HAVING COUNT(p.ID) = (
    SELECT MAX(project_count)
    FROM (
        SELECT COUNT(p1.ID) AS project_count
        FROM client c1
        LEFT JOIN project p1 ON c1.ID = p1.CLIENT_ID
        GROUP BY c1.NAME
    ) AS counts
);
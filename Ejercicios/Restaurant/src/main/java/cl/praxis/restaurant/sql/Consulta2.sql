
SELECT
    a.Nombre AS Categoria,
    SUM(a.Precio) / COUNT(a.ID) AS Promedio,
    AVG(a.Precio) AS AVG
FROM plato a
GROUP BY
    a.Nombre;

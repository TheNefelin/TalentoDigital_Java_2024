
SELECT
    a.id_comanda,
    SUM(IFNULL(b.cantidad_producto,0)) AS cantidad_productos
FROM comandas a
         LEFT JOIN detalles_comandas b ON b.id_comanda = a.id_comanda
GROUP BY
    a.id_comanda
HAVING
    SUM(IFNULL(b.cantidad_producto,0)) = 0;

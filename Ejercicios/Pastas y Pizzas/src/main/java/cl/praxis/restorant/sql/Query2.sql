
SELECT
    a.nombre,
    SUM(IFNULL(c.cantidad_producto, 0)) AS Ordenes
FROM garzones a
         LEFT JOIN comandas b ON b.id_garzon = a.id_garzon
         LEFT JOIN detalles_comandas c ON  c.id_comanda = b.id_comanda
GROUP BY
    a.nombre;

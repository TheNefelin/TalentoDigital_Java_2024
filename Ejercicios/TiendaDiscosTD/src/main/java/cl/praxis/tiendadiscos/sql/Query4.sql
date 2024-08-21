
SELECT
    a.sucursal_descripcion,
    c.disco_genero_musical,
    COUNT(b.venta_miembro_cantidad) AS cantidad_venta
FROM sucursal a
         INNER JOIN venta_miembro b ON b.sucursal_id = a.sucursal_id
         INNER JOIN disco c ON c.disco_id = b.disco_id
GROUP BY
    a.sucursal_descripcion,
    c.disco_genero_musical;

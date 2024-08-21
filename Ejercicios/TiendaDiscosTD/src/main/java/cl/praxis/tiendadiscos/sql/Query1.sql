
SELECT
    a.vendedor_nombre,
    a.vendedor_apellidos,
    b.sucursal_descripcion
FROM vendedor a
         INNER JOIN sucursal b ON b.sucursal_id = a.sucursal_id
WHERE
    b.sucursal_id = 1 or b.sucursal_id = 2;

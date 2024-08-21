
SELECT
    a.mascota_nombre,
    b.tipo_mascota_descripcion,
    d.sucursal_nombre
FROM mascota a
    INNER JOIN tipo_mascota b ON a.tipo_mascota_id = b.tipo_mascota_id
    INNER JOIN atencion c ON c.mascota_id = a.mascota_id
    INNER JOIN sucursal d ON d.sucursal_id = c.sucursal_id;

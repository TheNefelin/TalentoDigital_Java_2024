
SELECT
    COUNT(a.atencion_id) AS cant,
    c.medico_nombre,
    d.sucursal_nombre
FROM atencion a
    INNER JOIN tipo_atencion b ON b.tipo_atencion_id = a.tipo_atencion_id
    INNER JOIN medico c ON c.medico_id = a.medico_id
    INNER JOIN sucursal d ON d.sucursal_id = a.sucursal_id
WHERE
    b.tipo_atencion_descripcion = 'Cirugia'
GROUP BY
    c.medico_nombre,
    d.sucursal_nombre;

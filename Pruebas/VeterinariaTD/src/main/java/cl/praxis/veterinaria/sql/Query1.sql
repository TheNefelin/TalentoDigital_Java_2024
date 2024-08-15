
SELECT
    c.medico_nombre,
    c.medico_apellidos,
    a.sucursal_nombre
FROM sucursal a
    INNER JOIN medico_sucursal b ON a.sucursal_id = b.sucursal_id
    INNER JOIN medico c ON c.medico_id = b.medico_id;

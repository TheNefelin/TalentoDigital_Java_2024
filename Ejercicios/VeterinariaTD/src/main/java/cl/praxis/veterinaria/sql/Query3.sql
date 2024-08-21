
SELECT
    a.mascota_nombre,
    c.medico_nombre,
    c.medico_apellidos,
    d.tipo_atencion_descripcion
FROM mascota a
    INNER JOIN atencion b ON a.mascota_id = b.mascota_id
    INNER JOIN medico c ON c.medico_id = b.medico_id
    INNER JOIN tipo_atencion d ON d.tipo_atencion_id = b.tipo_atencion_id;

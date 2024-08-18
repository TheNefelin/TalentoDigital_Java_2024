SELECT
    a.tipo_membresia_descripcion,
    COUNT(b.miembro_id) AS numero_miembro
FROM tipo_membresia a
         INNER JOIN miembro b ON b.tipo_membresia_id = a.tipo_membresia_id
GROUP BY
    a.tipo_membresia_descripcion;

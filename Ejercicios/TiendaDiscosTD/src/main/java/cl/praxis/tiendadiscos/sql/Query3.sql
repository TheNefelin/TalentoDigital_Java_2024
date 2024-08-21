
SELECT
    a.miembro_nombre,
    a.miembro_apellidos,
    a.miembro_email,
    a.miembro_fecha_nacimiento,
    b.tipo_membresia_descripcion,
    c.genero_descripcion
FROM miembro a
         INNER JOIN tipo_membresia b ON b.tipo_membresia_id = a.tipo_membresia_id
         INNER JOIN genero c ON c.genero_id = a.genero_id
WHERE
    b.tipo_membresia_id = 1
ORDER BY
    a.miembro_apellidos,
    a.miembro_nombre;

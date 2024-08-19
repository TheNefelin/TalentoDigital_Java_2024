
SELECT
    a.curso_descripcion,
    b.especialidad_descripcion
FROM curso a
         INNER JOIN especialidad b ON b.especialidad_id = a.especialidad_id
WHERE
    b.especialidad_id = 1;

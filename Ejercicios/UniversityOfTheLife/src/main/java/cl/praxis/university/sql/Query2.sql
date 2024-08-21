
SELECT
    a.curso_descripcion,
    COUNT(b.alumno_id) AS alumnos
FROM curso a
         INNER JOIN alumno_curso b ON b.curso_id = a.curso_id
GROUP BY
    a.curso_descripcion
ORDER BY
    a.curso_descripcion;

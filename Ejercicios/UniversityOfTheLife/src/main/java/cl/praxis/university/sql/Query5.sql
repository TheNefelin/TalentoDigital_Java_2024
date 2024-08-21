
SELECT
    a.alumno_nombre,
    a.alumno_apellido,
    c.curso_descripcion,
    COUNT(d.alumno_curso_id) AS asistencia
FROM alumno a
         INNER JOIN alumno_curso b ON b.alumno_id = a.alumno_id
         INNER JOIN curso c ON c.curso_id = b.curso_id
         INNER JOIN asistencia_alumno_curso d ON d.alumno_curso_id = b.alumno_curso_id
WHERE
    d.asiste = 1
GROUP BY
    a.alumno_nombre,
    a.alumno_apellido,
    c.curso_descripcion
ORDER BY
    COUNT(d.alumno_curso_id) DESC;

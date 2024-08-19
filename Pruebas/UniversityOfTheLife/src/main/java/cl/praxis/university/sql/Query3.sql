
SELECT
    a.alumno_nombre,
    a.alumno_apellido,
    a.alumno_email,
    COUNT(c.curso_id) AS ramos
FROM alumno a
         INNER JOIN alumno_curso b ON b.alumno_id = a.alumno_id
         INNER JOIN curso c ON c.curso_id = b.curso_id
WHERE
    c.especialidad_id = 3
GROUP BY
    a.alumno_nombre,
    a.alumno_apellido,
    a.alumno_email
ORDER BY
    COUNT(c.curso_id);

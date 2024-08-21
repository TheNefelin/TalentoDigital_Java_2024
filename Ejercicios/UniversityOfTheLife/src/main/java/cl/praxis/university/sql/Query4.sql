
SELECT
    c.curso_descripcion,
    COUNT(a.alumno_curso_id)
FROM asistencia_alumno_curso a
         INNER JOIN alumno_curso b ON b.alumno_curso_id = a.alumno_curso_id
         INNER JOIN curso c ON c.curso_id = b.curso_id
WHERE
    a.asiste = 0
  AND a.fecha = '2024-05-01'
GROUP BY
    c.curso_descripcion;

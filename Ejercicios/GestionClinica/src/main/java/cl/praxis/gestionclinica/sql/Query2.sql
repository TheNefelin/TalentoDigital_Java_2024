
SELECT
    b.Diagnostico,
    COUNT(b.ID) AS Cantidad
FROM pacientes a
         INNER JOIN  historia_clinica b ON a.ID = b.Paciente_ID
GROUP BY
    b.Diagnostico
ORDER BY
    COUNT(b.ID) DESC;

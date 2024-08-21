
SELECT
    a.Nombre AS doctor,
    c.Nombre AS paciente
FROM doctores a
         INNER JOIN historia_clinica b ON b.Doctor_ID = a.ID
         INNER JOIN pacientes c ON c.ID = b.Paciente_ID
ORDER BY
    a.Nombre,
    c.Nombre;

SELECT
    a.Nombre AS doctor,
    c.Nombre AS paciente
FROM doctores a
         INNER JOIN citas b ON b.Doctor_ID = a.ID
         INNER JOIN pacientes c ON c.ID = b.Paciente_ID
ORDER BY
    a.Nombre,
    c.Nombre;

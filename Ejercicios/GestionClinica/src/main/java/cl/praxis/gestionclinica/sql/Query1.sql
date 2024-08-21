
SELECT
    a.Nombre
FROM pacientes a
         INNER JOIN historia_clinica b ON b.Paciente_ID = a.ID
         INNER JOIN doctores c ON c.ID = b.Doctor_ID
         INNER JOIN especialidades d ON d.ID = c.Especialidad_ID
WHERE
    d.ID = 3;

SELECT
    a.Nombre
FROM pacientes a
         INNER JOIN citas b ON b.Paciente_ID = a.ID
         INNER JOIN doctores c ON c.ID = b.Doctor_ID
         INNER JOIN especialidades d ON d.ID = c.Especialidad_ID
WHERE
    d.ID = 3;

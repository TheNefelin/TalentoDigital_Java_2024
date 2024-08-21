
SELECT
    a.Nombre,
    SUM(d.Monto) / COUNT(d.ID) AS Promedio,
    AVG(d.Monto) AS Prom2
FROM especialidades a
         INNER JOIN doctores b ON b.Especialidad_ID = a.ID
         INNER JOIN citas c ON c.Doctor_ID = b.ID
         INNER JOIN facturas d ON d.ID = c.Factura_ID
GROUP BY
    a.Nombre
ORDER BY
    a.Nombre;

SELECT
    a.Nombre,
    SUM(f.Monto) / COUNT(f.ID) AS Promedio,
    AVG(d.Monto) AS Prom2
FROM especialidades a
         INNER JOIN doctores b ON b.Especialidad_ID = a.ID
         INNER JOIN historia_clinica c ON c.Doctor_ID = b.ID
         INNER JOIN pacientes d ON d.ID = c.Paciente_ID
         INNER JOIN citas e ON e.Paciente_ID = d.ID
         INNER JOIN facturas f ON f.ID = e.Factura_ID
GROUP BY
    a.Nombre
ORDER BY
    a.Nombre;

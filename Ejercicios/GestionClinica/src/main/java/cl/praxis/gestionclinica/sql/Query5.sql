
SELECT
    a.Nombre,
    SUM(c.Monto) AS Total
FROM doctores a
         INNER JOIN citas b ON b.Doctor_ID = a.ID
         INNER JOIN facturas c ON c.ID = b.Factura_ID
GROUP BY
    a.Nombre
ORDER BY
    SUM(c.Monto) DESC;

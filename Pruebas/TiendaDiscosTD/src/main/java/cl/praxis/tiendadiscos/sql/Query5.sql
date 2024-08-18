
SELECT
    a.miembro_nombre,
    a.miembro_apellidos,
    b.tipo_membresia_descripcion,
    COUNT(c.venta_miembro_cantidad) AS vinillos_comprados
FROM miembro a
    INNER JOIN tipo_membresia b ON b.tipo_membresia_id = a.tipo_membresia_id
    INNER JOIN venta_miembro c ON c.miembro_id = a.miembro_id
GROUP BY
    a.miembro_nombre,
    a.miembro_apellidos,
    b.tipo_membresia_descripcion
ORDER BY
    SUM(c.venta_miembro_cantidad) DESC;

-- Esta deberia ser la version correcta
SELECT
    a.miembro_nombre,
    a.miembro_apellidos,
    b.tipo_membresia_descripcion,
    SUM(c.venta_miembro_cantidad) AS vinillos_comprados
FROM miembro a
         INNER JOIN tipo_membresia b ON b.tipo_membresia_id = a.tipo_membresia_id
         INNER JOIN venta_miembro c ON c.miembro_id = a.miembro_id
GROUP BY
    a.miembro_nombre,
    a.miembro_apellidos,
    b.tipo_membresia_descripcion
ORDER BY
    SUM(c.venta_miembro_cantidad) DESC;

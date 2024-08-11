SELECT
    a.usuario,
    a.clave,
    c.nombre AS rol,
    e.nombre AS permiso
FROM usuarios a
         INNER JOIN rol_usuario b ON a.id = b.id_usuario
         INNER JOIN roles c ON b.id_rol = c.id
         INNER JOIN rol_permiso d ON c.id = d.id_rol
         INNER JOIN permisos e ON e.id = d.id_permiso
ORDER BY
    a.usuario,
    c.nombre,
    e.nombre;
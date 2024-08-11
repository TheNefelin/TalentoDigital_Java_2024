INSERT INTO reportes
    (direccion, precio, habitacion, baño, imagen)
VALUES
    ('Calle 1, Ciudad A', 120000, 3, 2, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Calle 2, Ciudad B', 150000, 4, 3, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Avenida 3, Ciudad C', 180000, 2, 1, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Calle 4, Ciudad D', 200000, 5, 3, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Avenida 5, Ciudad E', 175000, 3, 2, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Calle 6, Ciudad F', 130000, 2, 1, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Avenida 7, Ciudad G', 220000, 4, 3, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Calle 8, Ciudad H', 160000, 3, 2, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Avenida 9, Ciudad I', 190000, 4, 2, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg'),
    ('Calle 10, Ciudad J', 210000, 5, 4, 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg');


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

SELECT * FROM reportes;
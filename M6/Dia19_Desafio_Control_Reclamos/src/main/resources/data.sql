INSERT INTO roles
    (rol)
VALUES
    ('ROLE_ADMIN'),
    ('ROLE_USER');

INSERT INTO usuarios
    (nombre, apellido, correo, clave, id_rol)
VALUES
    ('Clark', 'Kent', 'superman@dc.com', 'cryptonite', 1),
    ('Bruce', 'Whane', 'batman@dc.com', 'imbatman', 2);

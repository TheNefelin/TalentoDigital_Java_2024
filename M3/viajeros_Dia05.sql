
USE curso53;

CREATE TABLE generos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    estado TINYINT
);

ALTER TABLE generos
    MODIFY nombre VARCHAR(50) NOT NULL,
    MODIFY estado TINYINT NOT NULL;

INSERT INTO generos
    (nombre, estado)
VALUE
    ('Masculino', 1),
    ('Femenino', 1),
    ('Otros', 1);

CREATE TABLE viajeros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rut INT NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(255),
    telefono CHAR(50) NOT NULL,
    id_genero INT NOT NULL,
    CONSTRAINT fk_viajeros_generos FOREIGN KEY (id_genero) REFERENCES generos(id)
);

INSERT INTO Viajeros
    (rut, nombre, email, telefono, id_genero)
VALUES
    (123456789, 'Juan Perez', 'juan@email.com', '1111111111', 1),
    (987654321, 'Maria Rodriguez', 'maria@email.com', '2222222222', 2),
    (111222333, 'Carlos Gonzalez', 'carlos@email.com', '3333333333', 1),
    (444555666, 'Luisa Martinez', 'luisa@email.com', '4444444444', 2),
    (777888999, 'Pedro Hernandez', 'pedro@email.com', '5555555555', 1),
    (333444555, 'Ana Lopez', 'ana@email.com', '6666666666', 2),
    (666777888, 'Jorge Ramirez', 'jorge@email.com', '7777777777', 1),
    (999000111, 'Sofia Torres', 'sofia@email.com', '8888888888', 2),
    (222333444, 'Daniel Castro', 'daniel@email.com', '9999999999', 1),
    (555666777, 'Laura Garcia', 'laura@email.com', '0000000000', 2),
    (888999000, 'Manuel Silva', 'manuel@email.com', '1231231231', 1),
    (111123333, 'Elena Vargas', 'elena@email.com', '4564564564', 2),
    (222234444, 'Gabriel Morales','gabriel@email.com', '7897897897', 1),
    (333345555, 'Isabel Rios', 'isabel@email.com', '0120120120', 2),
    (444456666, 'Hector Mendoza', 'hector@email.com', '9876543210', 1);

CREATE TABLE paises (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    estado TINYINT NOT NULL
);

INSERT INTO paises
    (nombre, estado)
VALUES
    ('México', 1),
    ('Perú', 1),
    ('Chile', 1),
    ('Australia', 1),
    ('Nepal', 1),
    ('Grecia', 1),
    ('Marruecos', 1),
    ('Japón', 1);

CREATE TABLE ciudades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    estado TINYINT NOT NULL,
    -- codigo_postal INT NOT NULL,
    id_pais INT NOT NULL,
    CONSTRAINT fk_ciudades_paises FOREIGN KEY (id_pais) REFERENCES paises(id)
);

INSERT INTO ciudades
    (nombre, estado, id_pais)
VALUES
    ('Playa del Carmen', 1, 1),
    ('Cuzco', 1, 2),
    ('Puerto Natales', 1, 3),
    ('Queensland', 1, 4),
    ('Khumbu', 1, 5),
    ('Santorini', 1, 6),
    ('Marrakech', 1, 7),
    ('Kioto', 1, 8);

ALTER TABLE ciudades
    ADD COLUMN codigo_postal INT;

UPDATE ciudades SET codigo_postal = 12345 WHERE id = 1;
UPDATE ciudades SET codigo_postal = 54321 WHERE id = 2;
UPDATE ciudades SET codigo_postal = 67890 WHERE id = 3;
UPDATE ciudades SET codigo_postal = 11111 WHERE id = 4;
UPDATE ciudades SET codigo_postal = 22222 WHERE id = 5;
UPDATE ciudades SET codigo_postal = 33333 WHERE id = 6;
UPDATE ciudades SET codigo_postal = 44444 WHERE id = 7;
UPDATE ciudades SET codigo_postal = 55555 WHERE id = 8;

ALTER TABLE ciudades
    DROP COLUMN codigo_postal;

CREATE TABLE destinos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    id_ciudad INT NOT NULL,
    CONSTRAINT fk_destinos_ciudades FOREIGN KEY (id_ciudad) REFERENCES ciudades(id)
);

INSERT INTO destinos
    (nombre, id_ciudad)
VALUES
    ('Playa del Carmen', 1),
    ('Machu Picchu', 2),
    ('Torres del Paine', 3),
    ('Gran Barrera de Coral', 4),
    ('Monte Everest', 5),
    ('Santorini', 6),
    ('Marrakech', 7),
    ('Kioto', 8);

CREATE TABLE tickets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_viajero INT NOT NULL,
    id_destino INT NOT NULL,
    num_boleto VARCHAR(50) NOT NULL,
    fecha_emision DATETIME,
    fecha_salida DATETIME,
    fecha_retorno DATETIME,
    CONSTRAINT fk_tickets_viajeros FOREIGN KEY (id_viajero) REFERENCES viajeros(id),
    CONSTRAINT fk_tickets_destinos FOREIGN KEY (id_destino) REFERENCES destinos(id)
);

INSERT INTO Tickets
    (id_viajero, id_destino, num_boleto, fecha_emision, fecha_salida, fecha_retorno)
VALUES
    (1, 1, 'T111111', '2024-01-04', '2024-01-10', '2024-01-20'),
    (2, 2, 'T222222', '2024-01-05', '2024-02-01', '2024-02-15'),
    (2, 3, 'T333333', '2024-01-06', '2024-03-05', '2024-03-20'),
    (4, 4, 'T444444', '2024-01-07', '2024-04-12', '2024-05-01'),
    (5, 5, 'T555555', '2024-01-08', '2024-06-02', '2024-06-20'),
    (6, 1, 'T666666', '2024-01-09', '2024-07-15', '2024-08-01'),
    (4, 2, 'T777777', '2024-01-10', '2024-09-03', '2024-09-20'),
    (8, 3, 'T888888', '2024-01-11', '2024-10-18', '2024-11-01'),
    (9, 4, 'T999999', '2024-01-12', '2024-12-05', '2024-12-20'),
    (10, 5, 'T101010', '2024-01-13', '2025-01-02', '2025-01-20'),
    (15, 1, 'T1111111', '2024-01-14', '2025-02-10', '2025-02-25'),
    (12, 2, 'T121212', '2024-01-15', '2025-03-15', '2025-04-01'),
    (13, 3, 'T131313', '2024-01-16', '2025-05-02', '2025-05-20'),
    (14, 4, 'T141414', '2024-01-17', '2025-06-12', '2025-06-30'),
    (15, 5, 'T151515', '2024-01-18', '2025-07-20', '2025-08-05');

-- -----------------------------------------------------------------------------
-- -----------------------------------------------------------------------------

-- 1. Obtener una lista de todos los viajeros y la información de sus boletos, incluyendo
-- aquellos viajeros que no tengan boletos emitidos. En el caso de los viajeros con

SELECT
    a.rut,
    a.nombre,
    a.email,
    a.telefono,
    a.rut,
    b.nombre AS genero,
    c.num_boleto,
    c.fecha_emision,
    c.fecha_salida,
    c.fecha_retorno,
    d.nombre AS destino
FROM viajeros AS a
    INNER JOIN generos b ON a.id_genero = b.id
    LEFT JOIN tickets c ON a.id = c.id_viajero
    LEFT JOIN destinos d ON c.id_destino = d.id;

-- 2. Mostrar la información del boleto T123456 junto con los detalles del viajero y destino
-- correspondiente a ese boleto.

SELECT
    a.rut,
    a.nombre,
    a.email,
    a.telefono,
    a.rut,
    b.nombre AS genero,
    c.num_boleto,
    c.fecha_emision,
    c.fecha_salida,
    c.fecha_retorno,
    d.nombre AS destino
FROM viajeros AS a
         INNER JOIN generos b ON a.id_genero = b.id
         LEFT JOIN tickets c ON a.id = c.id_viajero
         LEFT JOIN destinos d ON c.id_destino = d.id
WHERE
    c.num_boleto = 'T123456';

-- 3. Listar todos los viajeros que tienen fecha de salida o de retorno el '2024-01-10'

SELECT
    a.rut,
    a.nombre,
    a.email,
    a.telefono,
    a.rut,
    b.nombre AS genero,
    c.num_boleto,
    c.fecha_emision,
    c.fecha_salida,
    c.fecha_retorno,
    d.nombre AS destino
FROM viajeros AS a
         INNER JOIN generos b ON a.id_genero = b.id
         LEFT JOIN tickets c ON a.id = c.id_viajero
         LEFT JOIN destinos d ON c.id_destino = d.id
WHERE
    c.fecha_salida = '2024-01-10' OR
    c.fecha_retorno = '2024-01-10';

-- 4. Obtener el número total de boletos por cada género

SELECT
    a.nombre AS genero,
    COUNT(c.num_boleto) AS cant_boleto
FROM generos a
    INNER JOIN viajeros b ON a.id = b.id_genero
    INNER JOIN tickets c ON b.id = c.id_viajero
GROUP BY
    a.nombre;

-- 5. Obtener un listado de todos los viajeros que han viajado a Playa del Carmen

SELECT
    a.rut,
    a.nombre,
    a.email,
    a.telefono,
    a.rut,
    b.nombre AS genero,
    d.nombre AS destino
FROM viajeros AS a
         INNER JOIN generos b ON a.id_genero = b.id
         LEFT JOIN tickets c ON a.id = c.id_viajero
         LEFT JOIN destinos d ON c.id_destino = d.id
WHERE
    d.nombre = 'Playa del Carmen';

-- Paso 7

SELECT
    a.nombre,
    c.num_boleto,
    d.nombre AS destino
FROM viajeros AS a
         INNER JOIN generos b ON a.id_genero = b.id
         LEFT JOIN tickets c ON a.id = c.id_viajero
         LEFT JOIN destinos d ON c.id_destino = d.id;

-- Ingresa tres nuevos tickets con la siguiente información:

INSERT INTO Tickets
    (id_viajero, id_destino, num_boleto, fecha_salida, fecha_retorno)
VALUES
    (4, 3, 'T171717', '2024-03-28', '2024-04-01');

INSERT INTO Tickets
    (id_viajero, id_destino, num_boleto, fecha_salida, fecha_retorno)
VALUES
    (10, 5, 'T888888', '2024-03-28', '2024-04-01');

INSERT INTO Tickets
    (id_destino, num_boleto, fecha_salida, fecha_retorno)
VALUES
    (3, 'T202020', '2024-03-28', '2024-04-01');

-- A continuación borra los siguientes registros:

DELETE FROM tickets WHERE id IN (2, 4, 5);

-- Mostrar la información del boleto T123456 junto con los detalles del viajero y destino
-- correspondiente a ese boleto.

SELECT
    b.*, c.*, d.*
FROM generos a
    INNER JOIN viajeros b ON a.id = b.id_genero
    INNER JOIN tickets c ON b.id = c.id_viajero
    INNER JOIN destinos d on c.id_destino = d.id
WHERE
    c.num_boleto = 'T666666';

-- -----------------------------------------------------------------------------
-- -----------------------------------------------------------------------------

SELECT * FROM generos;
SELECT * FROM viajeros;
SELECT * FROM paises;
SELECT * FROM ciudades;
SELECT * FROM destinos;
SELECT * FROM tickets;

DROP TABLE tickets;
DROP TABLE destinos;
DROP TABLE ciudades;
DROP TABLE paises;
DROP TABLE viajeros;
DROP TABLE generos;
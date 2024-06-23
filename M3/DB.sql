-- Creación DB
CREATE DATABASE curso53;

-- Selección del schema
USE curso53;

-- Creación de Tablas
CREATE TABLE Clients(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    first_surname VARCHAR(50) NOT NULL,
    second_surname VARCHAR(50) NULL,
    date_born DATE NOT NULL,
    is_visible TINYINT CHECK(is_visible IN(0,1))
);

-- Inserción de una fila
INSERT INTO Clients
    (name, first_surname, second_surname, date_born, is_visible)
VALUES
    ('Rene', 'Moreno', 'Vera', '1993-08-11', 0);

-- Inserción de más una fila
INSERT INTO Clients
( name, first_surname, second_surname, date_born, is_visible)
VALUES ('Tiare', 'Linco', 'Toloza', '1993-06-11', 0),
       ('Andrea', 'Jiménez', 'Espinoza', '1975-07-28', 0),
       ('Freddy', 'Maldonado', 'Maldonado', '1981-10-02', 0),
       ('Bastian', 'Rojas', 'Berríos', '1996-07-01', 0),
       ('Franco', 'Ortiz', 'Cabrera', '1997-04-26', 0);

-- Consultas
SELECT * FROM Clients;

-- Tabla Pedidos
CREATE TABLE Orders(
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       total VARCHAR(50) NOT NULL,
                       id_cliente INT NOT NULL
);

ALTER TABLE Orders
    CHANGE id_cliente id_clients INT NOT NULL;

ALTER TABLE Orders
    RENAME COLUMN id_clients TO id_client;

ALTER TABLE Orders
    ADD CONSTRAINT fk_id_clients FOREIGN KEY (id_client) REFERENCES Clients (id);

INSERT INTO Orders
(total, id_client)
VALUES
    (3500, 1),
    (2000, 2),
    (2500,2),
    (23487, 3),
    (723737,4);

SELECT
    id_client, Sum(Orders.total) as total
FROM Orders
Group By
    id_client
ORDER BY
    total;

-- Join
SELECT
    c.name, c.first_surname, o.total
FROM Orders o
         JOIN Clients c ON c.id = o.id_client;

-- Tabla Colaboradores
CREATE TABLE Colaboradores(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    sueldo INT NOT NULL,
    departamento VARCHAR(30) NOT NULL
);

-- Inserción de Colaboradores
INSERT INTO Colaboradores
(nombre, apellido, sueldo, departamento)
VALUES
    ('Juan', 'Perez', 3000, 'ventas'),
    ('Maria', 'Gonzalez', 3500, 'MKT'),
    ('Carlos', 'Rodriguez', 4000, 'Tecnología'),
    ('Ana', 'Martinez', 2800, 'RRHH'),
    ('Luis', 'Garcia', 3200, 'Fnanzas');

-- Consulta unica
SELECT AVG(c.sueldo) AS promedio_sueldo FROM Colaboradores AS c;

-- Consulta Anidada
SELECT
    c.id, c.nombre, c.apellido, c.sueldo, c.departamento
FROM Colaboradores as c
WHERE
    sueldo > (SELECT AVG(c.sueldo) FROM Colaboradores as c);

-- Ejercicio

CREATE TABLE clientes (
    id INTEGER UNIQUE NOT null,
    name VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL DEFAULT 'na'
);

INSERT INTO clientes
    (id, name)
VALUES
    (1, 'Nombre 1'),
    (2, 'Nombre 2'),
    (3, 'Nombre 3');

INSERT INTO clientes (id, name, email) VALUES (4, 'Nombre 99', DEFAULT);

ALTER TABLE clientes
    ALTER COLUMN email SET NOT NULL;

ALTER TABLE clientes MODIFY email VARCHAR(50) NOT NULL DEFAULT 'na';

SELECT * FROM clientes;

-- ---------------------------------------------------------------
-- ---------------------------------------------------------------

CREATE TABLE autores (
    id INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE libros (
    id INT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor_id INT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autores (id)
);

INSERT INTO autores
    (id, nombre)
VALUES
    (1, 'Juan Pérez'),
    (2, 'María García'),
    (3, 'Pedro Rodríguez');

INSERT INTO libros
    (id, titulo, autor_id)
VALUES
    (1, 'El Quijote', 1),
    (2, 'La Divina Comedia', 2),
    (3, 'Hamlet', 3);

SELECT
    *
FROM autores a
    INNER JOIN libros b ON a.id = b.autor_id;

DELETE FROM libros WHERE TRUE;
DELETE FROM autores WHERE TRUE;

TRUNCATE TABLE libros;
TRUNCATE TABLE autores;

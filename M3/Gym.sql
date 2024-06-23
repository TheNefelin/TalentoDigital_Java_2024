
CREATE DATABASE java_gym;

USE java_gym;

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    rut INT NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE matriculas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    monto INT NOT NULL,
    estado TINYINT NOT NULL,
    id_cliente INT,
    CONSTRAINT fk_matriculas_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

INSERT INTO clientes
    (nombre, apellido, rut, email)
VALUES
    ('Cliente 1', 'Apellido cliente 1', 999999999, 'cliente1@email.com'),
    ('Cliente 2', 'Apellido cliente 2', 888888888, 'cliente2@email.com'),
    ('Cliente 3', 'Apellido cliente 3', 777777777, 'cliente3@email.com'),
    ('Cliente 4', 'Apellido cliente 4', 666666666, 'cliente4@email.com'),
    ('Cliente 5', 'Apellido cliente 5', 555555555, 'cliente5@email.com');

INSERT INTO matriculas
    (monto, estado, id_cliente)
VALUES
    (40000, 1, 1),
    (40000, 0, 2),
    (35000, 1, 3),
    (60000, 1, 4),
    (55000, 0, 5);

SELECT
    a.email,
    a.rut,
    b.monto,
    b.estado
FROM clientes a
    INNER JOIN matriculas b ON a.id = b.id_cliente;

SELECT
    a.email,
    a.rut,
    b.monto,
    b.estado
FROM clientes a
    INNER JOIN matriculas b ON a.id = b.id_cliente
ORDER BY
    b.monto;

SELECT
    monto,
    count(monto) AS cant
FROM matriculas
GROUP BY
    monto
HAVING
    count(monto) >= 2;

SELECT
    b.monto,
    b.estado,
    a.id
FROM clientes a
    INNER JOIN matriculas b ON a.id = b.id_cliente
WHERE
    a.rut = 777777777;

INSERT INTO matriculas (monto, estado, id_cliente)
VALUES (35000, 1, 3);

SELECT
    a.email,
    a.rut,
    b.monto,
    b.estado,
    count(b.id) AS cant_matriculas
FROM clientes a
    INNER JOIN matriculas b ON a.id = b.id_cliente
GROUP BY
    a.email,
    a.rut,
    b.monto,
    b.estado;

SELECT
    a.email,
    a.rut,
    b.monto,
    b.estado,
    count(b.id) AS cant_matriculas
FROM clientes a
         INNER JOIN matriculas b ON a.id = b.id_cliente
GROUP BY
    a.email,
    a.rut,
    b.monto,
    b.estado
HAVING
    count(b.id) >= 2;

-- DELETE FROM matriculas WHERE TRUE;
-- DELETE FROM clientes WHERE TRUE;

ALTER TABLE clientes ADD COLUMN estado TINYINT;

UPDATE clientes SET estado = 0 WHERE TRUE;

ALTER TABLE clientes MODIFY estado TINYINT NOT NULL;

ALTER TABLE matriculas ADD COLUMN fecha DATETIME;

UPDATE matriculas SET fecha = '2024-03-22 15:15' WHERE TRUE;

ALTER TABLE matriculas MODIFY fecha DATETIME NOT NULL;

INSERT INTO clientes
    (nombre, apellido, rut, email, estado)
VALUES
    ('Cliente 6', 'Apellido cliente 6', 444444444, 'cliente6@email.com', 1),
    ('Cliente 7', 'Apellido cliente 7', 333333333, 'cliente7@email.com', 1);

INSERT INTO matriculas
    (monto, estado, id_cliente, fecha)
VALUES
    (40000, 1, 7, NOW()),
    (40000, 1, 7, NOW());

SELECT
    a.email,
    a.rut,
    b.monto,
    b.estado,
    count(b.id) AS cant_matriculas
FROM clientes a
         INNER JOIN matriculas b ON a.id = b.id_cliente
GROUP BY
    a.email,
    a.rut,
    b.monto,
    b.estado
HAVING
    count(b.id) >= 2;

SELECT * FROM clientes;
SELECT * FROM matriculas;

-- -----------------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------------

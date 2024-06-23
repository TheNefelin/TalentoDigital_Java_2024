CREATE DATABASE mawashi_cars_spa;

USE mawashi_cars_spa;

CREATE TABLE autos (
    id INT PRIMARY KEY,
    marca VARCHAR(25) NOT NULL,
    modelo VARCHAR(25) NOT NULL,
    anio VARCHAR(4) NOT NULL,
    color VARCHAR(25),
    precio FLOAT
);

INSERT INTO autos
    (id, marca, modelo, anio, color, precio)
VALUE
    (1, 'Toyota', 'Corolla Araya', '1991', 'Blanco', 1200000),
    (2, 'Mazda', 'Mazda 3', '2000', 'Azul',2000000),
    (3, 'Chevrolet', 'Spark', '1998', 'Verde Oscuro', 1200000),
    (4, 'Nissan', 'Versa', '2018', 'Gris Plata', 5000000),
    (5, 'Hyundai', 'Accent', '2022', 'Rojo', 10500000),
    (6, 'Kia', 'Rio', '2020', 'Negro', 8000000),
    (7, 'Volkswagen', 'Gol', '2015', 'Azul Marino', 3500000),
    (8, 'Fiat', 'Mobi', '2017', 'Blanco', 2800000),
    (9, 'Suzuki', 'Swift', '2019', 'Gris Oxford', 6200000),
    (10, 'Peugeot', '208', '2021', 'Rojo', 9800000);

CREATE TABLE ventas(
    id SERIAL UNIQUE NOT NULL,
    fecha VARCHAR(20) NOT NULL,
    cliente VARCHAR(25) NOT NULL,
    referencia INT NOT NULL,
    cantidad FLOAT NOT NULL,
    metodo_pago VARCHAR(10) NOT NULL,
    id_auto INT NOT NULL,
    CONSTRAINT fk_ventas_autos FOREIGN KEY (id_auto) REFERENCES autos(id)
);

INSERT INTO ventas
    (fecha, cliente, referencia, cantidad, metodo_pago, id_auto)
VALUES
    ('2020-10-15', 'Chuck', 43224, 12000000, 'Débito', 1),
    ('2020-11-15', 'Donnie', 43334, 12000000, 'Transfer', 1),
    ('2020-12-15', 'Jet', 43444, 12000000, 'Cheque', 3),
    ('2021-01-05', 'Peter', 43335, 12000000, 'Débito', 1),
    ('2021-01-15', 'Abigail', 43554, 12000000, 'Transfer', 1),
    ('2021-02-01', 'Jhon', 43456, 12000000, 'Cheque', 3),
    ('2021-02-01', 'Walter', 54321, 2000000, 'Efectivo', 2),
    ('2021-03-15', 'Sarah', 54322, 1200000, 'Tarjeta', 3),
    ('2021-04-05', 'Jessica', 54323, 5000000, 'Débito', 4),
    ('2021-05-25', 'Luis', 54324, 10500000, 'Transfer', 5);

SELECT
    a.*,
    b.*
FROM ventas a
     INNER JOIN autos b ON a.id_auto = b.id;

-- Ejercicio propuesto 1
SELECT
    a.id,
    a.marca,
    a.modelo,
    a.anio,
    a.color,
    a.precio
FROM autos a
    LEFT JOIN ventas b ON a.id = b.id_auto
WHERE
    b.id IS NULL;

-- Ejercicio propuesto 2
SELECT
    a.id,
    a.marca,
    a.modelo,
    a.anio,
    a.color,
    a.precio,
    b.id,
    b.fecha,
    b.cliente,
    b.referencia,
    b.cantidad,
    b.metodo_pago,
    b.id_auto
FROM autos a
    LEFT JOIN ventas b ON a.id = b.id_auto
WHERE
    b.id IS NULL

UNION ALL

SELECT
    a.id,
    a.marca,
    a.modelo,
    a.anio,
    a.color,
    a.precio,
    b.id,
    b.fecha,
    b.cliente,
    b.referencia,
    b.cantidad,
    b.metodo_pago,
    b.id_auto
FROM autos a
    RIGHT JOIN ventas b ON a.id = b.id_auto
WHERE
    a.id IS NULL;

-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
-- Para ver la magia

ALTER TABLE ventas
    DROP FOREIGN KEY fk_ventas_autos;

DELETE FROM autos WHERE id IN (3, 4);

SELECT
    a.id,
    a.marca,
    a.modelo,
    a.anio,
    a.color,
    a.precio,
    b.id,
    b.fecha,
    b.cliente,
    b.referencia,
    b.cantidad,
    b.metodo_pago,
    b.id_auto
FROM autos a
    LEFT JOIN ventas b ON a.id = b.id_auto
WHERE
    b.id IS NULL

UNION ALL

SELECT
    a.id,
    a.marca,
    a.modelo,
    a.anio,
    a.color,
    a.precio,
    b.id,
    b.fecha,
    b.cliente,
    b.referencia,
    b.cantidad,
    b.metodo_pago,
    b.id_auto
FROM autos a
    RIGHT JOIN ventas b ON a.id = b.id_auto
WHERE
    a.id IS NULL;

-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
-- ALTER TABLE ventas
--    ADD CONSTRAINT fk_ventas_autos FOREIGN KEY (id_auto) REFERENCES autos(id);

-- DROP TABLE ventas;
-- DROP TABLE autos;

-- SELECT * FROM autos;
-- SELECT * FROM ventas;

SHOW COLUMNS  FROM autos;
SHOW COLUMNS  FROM ventas;

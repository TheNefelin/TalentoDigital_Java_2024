USE bank_db;

-- DROP TABLE inscritos;

CREATE TABLE IF NOT EXISTS inscritos (
    cantidad INT,
    fecha DATE,
    fuente VARCHAR(50)
);

INSERT INTO inscritos
    (cantidad, fecha, fuente)
VALUES
    (44, '2021-01-01', 'Blog'),
    (56, '2021-01-01', 'Página'),
    (39, '2021-02-01', 'Blog'),
    (81, '2021-02-01', 'Página'),
    (12, '2021-03-01', 'Blog'),
    (91, '2021-03-01', 'Página'),
    (48, '2021-04-01', 'Blog'),
    (45, '2021-04-01', 'Página'),
    (55, '2021-05-01', 'Blog'),
    (33, '2021-05-01', 'Página'),
    (18, '2021-06-01', 'Blog'),
    (12, '2021-06-01', 'Página'),
    (34, '2021-07-01', 'Blog'),
    (24, '2021-07-01', 'Página'),
    (83, '2021-08-01', 'Blog'),
    (99, '2021-08-01', 'Página');

SELECT * FROM inscritos;

-- 1. ¿Cuántos registros hay?
    SELECT COUNT(cantidad) AS cant FROM inscritos;

-- 2. ¿Cuántos inscritos hay en total?
    SELECT SUM(cantidad) AS cant FROM inscritos;

-- 3. ¿Cuál o cuáles son los registros de mayor antigüedad? HINT: ocupar subconsultas
    SELECT
        cantidad,
        fecha,
        fuente
    FROM inscritos
    WHERE
        fecha IN (SELECT MAX(fecha) FROM inscritos);

-- 4. ¿Cuántos inscritos hay por día? (entendiendo un día como una fecha distinta de ahora en adelante)
    SELECT
        COUNT(cantidad) AS cant,
        fecha
    FROM inscritos
    GROUP BY
        fecha;

-- 5. ¿Qué día se inscribieron la mayor cantidad de personas y cuántas personas se inscribieron en ese día?
    SELECT
        SUM(cantidad) AS cant,
        fecha
    FROM inscritos
    GROUP BY
        fecha
    ORDER BY
        SUM(cantidad) DESC;

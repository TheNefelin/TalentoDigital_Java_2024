CREATE DATABASE prueba_m3;

USE prueba_m3;

-- 1. Crea el modelo (revisa bien cuál es el tipo de relación antes de crearlo), respeta las claves primarias, foráneas y tipos de datos.
CREATE TABLE peliculas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    anio INT NOT NULL
);

CREATE TABLE tags (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tag VARCHAR(32) NOT NULL
);

CREATE TABLE peliculas_tags (
    id_pelicula INT NOT NULL,
    id_tag INT NOT NULL,
    CONSTRAINT pk_pt_pelicula FOREIGN KEY (id_pelicula) REFERENCES peliculas(id),
    CONSTRAINT pk_pt_tag FOREIGN KEY (id_tag) REFERENCES tags(id)
);

-- 2. Inserta 5 películas y 5 tags, la primera película tiene que tener 3 tags asociados, la segunda película debe tener dos tags asociados.
INSERT INTO peliculas
    (nombre, anio)
VALUE
    ('Star Wars: Episodio I', 1999),
    ('Star Wars: Episodio II', 2002),
    ('Star Wars: Episodio III', 2005),
    ('Star Wars: Episodio IV', 1977),
    ('Star Wars: Episodio V', 1980);

INSERT INTO tags
    (tag)
VALUES
    ('Terror'),
    ('George Lucas'),
    ('Harrison Ford'),
    ('Jake Lloyd'),
    ('Natalie Portman');

INSERT INTO peliculas_tags
    (id_pelicula, id_tag)
VALUES
    (1, 2),
    (1, 4),
    (1, 5),
    (4, 2),
    (4, 3);

-- 3 Cuenta la cantidad de tags que tiene cada película. Si una película no tiene tags debe mostrar 0.
SELECT
    a.nombre AS pelicula,
    COUNT(b.id_tag) AS cant_tag
FROM peliculas a
    LEFT JOIN peliculas_tags b ON a.id = b.id_pelicula
    LEFT JOIN tags c on b.id_tag = c.id
GROUP BY
    a.nombre;

-- 4. Crea las tablas respetando los nombres, tipos, claves primarias y foráneas y tipos de datos.
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL
);

CREATE TABLE preguntas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    preguntas VARCHAR(255) NOT NULL,
    respuesta_correcta TINYINT NOT NULL
);

CREATE TABLE respuestas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    respuesta VARCHAR(255) NOT NULL,
    id_usuario INT NOT NULL,
    id_pregunta INT NOT NULL,
    CONSTRAINT pk_respuestas_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    CONSTRAINT pk_respuestas_preguntas FOREIGN KEY (id_pregunta) REFERENCES preguntas(id)
);

-- 5. Agrega 5 registros a la tabla preguntas,
INSERT INTO preguntas
    (preguntas, respuesta_correcta)
VALUES
    ('¿Un lenguaje de programación orientado a objetos utiliza objetos y clases para organizar y estructurar el código?', 1),
    ('¿Una excepción en programación siempre interrumpe el flujo normal del programa?', 1),
    ('¿Una lista vinculada siempre almacena sus elementos de forma contigua en memoria?', 0),
    ('¿El "scope" en programación se refiere al alcance o contexto en el que una variable o función puede ser accedida?', 1),
    ('¿La optimización del código no tiene impacto en el rendimiento y la eficiencia de un programa?', 0);

INSERT INTO usuarios
    (nombre, edad)
VALUES
    ('Isaac Netero', 125),
    ('Zeno Zoldyck', 75);

INSERT INTO respuestas
    (respuesta, id_usuario, id_pregunta)
VALUES
    (1, 1, 1),
    (1, 2, 1),
    (0, 1, 2),
    (1, 2, 2),
    (1, 1, 3),
    (1, 2, 3),
    (0, 1, 4),
    (0, 2, 4);

-- 6. Cuenta la cantidad de respuestas correctas totales por usuario (independiente de la pregunta).
SELECT
    a.nombre,
    COUNT(c.id) AS respuestas_correctas
FROM usuarios a
    INNER JOIN respuestas b ON a.id = b.id_usuario
    INNER JOIN preguntas c ON b.id_pregunta = c.id AND b.respuesta = c.respuesta_correcta
GROUP BY
    a.nombre;

-- 7. Por cada pregunta, en la tabla preguntas, cuenta cuántos usuarios tuvieron la respuesta correcta.
SELECT
    c.preguntas,
    SUM(c.respuestas) AS respuesta_correcta
FROM
    (SELECT
        a.preguntas,
        CASE
            WHEN a.respuesta_correcta = b.respuesta THEN 1
            WHEN a.respuesta_correcta <> b.respuesta THEN 0
        END AS respuestas
    FROM preguntas a
        LEFT JOIN respuestas b ON a.id = b.id_pregunta) AS c
GROUP BY
    c.preguntas;

SELECT
    a.preguntas,
    SUM(CASE
        WHEN a.respuesta_correcta = b.respuesta THEN 1
        WHEN a.respuesta_correcta <> b.respuesta THEN 0
    END) AS respuesta_correcta
FROM preguntas a
    LEFT JOIN respuestas b ON a.id = b.id_pregunta
GROUP BY
    a.preguntas;

SELECT
    a.preguntas,
    IFNULL(COUNT(b.id), 0) as respuestas_correctas
FROM preguntas a
    LEFT JOIN respuestas b on a.id = b.id_pregunta AND a.respuesta_correcta = b.respuesta
GROUP BY
    a.preguntas;

-- 8. Implementa borrado en cascada de las respuestas al borrar un usuario y borrar el primer usuario para probar la implementación.
DELETE FROM respuestas WHERE id_usuario = 1;
DELETE FROM usuarios WHERE id = 1;

-- 9. Crea una restricción que impida insertar usuarios menores de 18 años en la base de datos.
ALTER TABLE usuarios
    MODIFY COLUMN edad INT NOT NULL CHECK (edad >= 18);

-- 10. Altera la tabla existente de usuarios agregando el campo email con la restricción de único.
ALTER TABLE usuarios
    ADD COLUMN email VARCHAR(50) UNIQUE;

-- ------------------------------------------------------------------
SELECT
    a.preguntas,
    SUM(b.respuesta) AS respuesta
FROM preguntas a
    INNER JOIN respuestas b on a.id = b.id_pregunta
WHERE
    a.respuesta_correcta = b.respuesta
GROUP BY
    a.preguntas

UNION

SELECT DISTINCT
    a.preguntas,
    0 AS respuesta
FROM preguntas a
    INNER JOIN respuestas b on a.id = b.id_pregunta
WHERE
    a.respuesta_correcta <> b.respuesta;

-- ------------------------------------------------------------------
SELECT * FROM peliculas_tags;
SELECT * FROM peliculas;
SELECT * FROM tags;
SELECT * FROM respuestas;
SELECT * FROM usuarios;
SELECT * FROM preguntas;

-- DROP TABLE peliculas_tags;
-- DROP TABLE peliculas;
-- DROP TABLE tags;
-- DROP TABLE respuestas;
-- DROP TABLE usuarios;
-- DROP TABLE preguntas;
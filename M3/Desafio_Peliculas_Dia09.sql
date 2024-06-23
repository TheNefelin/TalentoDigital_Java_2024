-- 1. Crear una base de datos llamada películas.
CREATE DATABASE peliculas;
USE peliculas;

-- 2. Cargar ambos archivos a su tabla correspondiente.
        -- paso 1: click derecho en la bsae de daatos
        -- paso 2: click en import/export
        -- paso 3: click en import data from file(s) ...
        -- paso 4: seleccionar los archivos
        -- paso 5: click en OK
        -- paso 6: renombrar campo `Año estreno` en la tabla peliculas

        ALTER TABLE peliculas
            CHANGE `Año estreno` Anio_Estreno INT NULL;

        SELECT * FROM peliculas;
        SELECT * FROM reparto;

-- 3. Obtener el ID de la película “Titanic”.
SELECT id FROM peliculas WHERE pelicula = 'Titanic';

-- 4. Listar a todos los actores que aparecen en la película "Titanic".
SELECT
    b.actor
FROM peliculas a
    INNER JOIN reparto b ON a.id = b.id_pelicula
WHERE
    a.id = 2;

-- 5. Consultar en cuántas películas del top 100 participa Harrison Ford.
SELECT
    COUNT(a.id) AS cant_peliculas
FROM peliculas a
    INNER JOIN reparto b ON a.id = b.id_pelicula
WHERE
    b.actor = 'Harrison Ford';

-- 6. Indicar las películas estrenadas entre los años 1990 y 1999 ordenadas por título de manera ascendente.
SELECT
    pelicula
FROM peliculas
WHERE
    Anio_Estreno BETWEEN 1990 AND 1999
ORDER BY
    Pelicula ASC;

-- 7. Hacer una consulta SQL que muestre los títulos con su longitud, la longitud debe ser nombrado para la consulta como “longitud_titulo”.
SELECT
    pelicula,
    LENGTH(pelicula) AS longitud_titulo
FROM peliculas;

-- 8. Consultar cual es la longitud más grande entre todos los títulos de las películas.
SELECT
    MAX(LENGTH(pelicula)) AS maxima_longitud_titulo
FROM peliculas;

CREATE DATABASE peliculas;
USE peliculas;

-- 10.2
SELECT id FROM peliculas WHERE pelicula = 'Titanic';
-- Paso 11
SELECT MAX(`Año estreno`) FROM peliculas;
-- A continuación, deberás desarrollar dos consultas
SELECT COUNT(id) FROM peliculas WHERE director = 'Peter Jackson';
SELECT pelicula, `Año estreno` FROM peliculas WHERE director = 'Peter Jackson';

-- Version Manual
CREATE TABLE peliculas2 AS SELECT * FROM peliculas WHERE id = 0;
SHOW VARIABLES LIKE 'secure_file_priv';

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/peliculas.csv'
    INTO TABLE peliculas2
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 ROWS;

-- --------------------------------------------------------------------------
-- --------------------------------------------------------------------------

CREATE table peliculas (
    id INT NULL,
    Pelicula TEXT NULL,
    Estreno INT NULL,
    Director TEXT NULL
);

create table reparto
(
    id_pelicula INT NULL,
    actor TEXT NULL
);

-- copiar los archivos CSV a la ruta de...
SHOW VARIABLES LIKE 'secure_file_priv';

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/peliculas.csv'
    INTO TABLE peliculas
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 ROWS;

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/reparto.csv'
    INTO TABLE reparto
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 ROWS;

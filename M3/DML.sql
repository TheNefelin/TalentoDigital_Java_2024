USE curso53;

CREATE TABLE comidas_chilenas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

INSERT INTO comidas_chilenas
    (nombre)
VALUES
    ('Pastel de Choclo'),
    ('Umitas');

UPDATE comidas_chilenas SET nombre = 'Humita' WHERE id = 2;

INSERT INTO comidas_chilenas
    (nombre)
VALUES
    ('Porotos Granados'),
    ('Cazuela'),
    ('Empanada');

CREATE TABLE animales (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    raza VARCHAR(50) NOT NULL,
    edad INT NOT NULL
);

INSERT INTO animales
    (nombre, raza, edad)
VALUES
    ('Apolo', 'Caniche', 3),
    ('Cuchita', 'Calico', 2),
    ('Puppy', 'Mestizo', 1),
    ('Kimchi', 'quiltro', 5),
    ('Chicho', 'Azul Ruso', 3),
    ('yuki', 'calico', 10);

UPDATE animales SET raza = 'Calicó' WHERE raza = 'Calico';
UPDATE animales SET raza = 'Mestizo' WHERE id = 4;
UPDATE animales SET nombre = 'Yuki' WHERE id = 6;

DELETE FROM animales WHERE id IN (4, 6);

SELECT * FROM animales;

-- SELECT * FROM comidas_chilenas WHERE id IN (1, 3, 5);

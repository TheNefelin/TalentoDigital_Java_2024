# Heroes

[PicoCSS](https://picocss.com/docs)

### Dependencias
```
<!-- Testing -->
<!-- JUnit 5 API dependency for writing tests -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>

<!-- JUnit 5 Engine dependency for running tests -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>

<!-- Mockito dependency for mocking objects in tests -->
<dependency>
<groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>

<!-- JSTL => <%@ taglib prefix="c" uri="jakarta.tags.core" %> -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.0</version>
</dependency>
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
</dependency>

<!-- MySQL -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```

### MySQL
```
CREATE DATABASE heroes;
USE heroes;

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    correo VARCHAR(50) UNIQUE NOT NULL,
    clave VARCHAR(50) NOT NULL
);

CREATE TABLE generos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE clases (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE heroes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    id_genero INT NOT NULL,
    id_clase INT NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT fk_heroe_genero FOREIGN KEY (id_genero) REFERENCES generos(id),
    CONSTRAINT fk_heroe_clase FOREIGN KEY (id_clase) REFERENCES clases(id),
    CONSTRAINT fk_heroe_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

INSERT INTO generos
    (nombre)
VALUES
    ('Masculino'),
    ('Femenino');
    
INSERT INTO clases
    (nombre)
VALUES
    ('Guerrero/a'),
    ('Mago/a'),
    ('Paladín/a'),
    ('Berserker'),
    ('Arquero/a'),
    ('Asesino/a'),
    ('Hechicero/a'),
    ('Nigromante'),
    ('Druida');
    
SELECT 
    a.id,
    a.nombre,
    b.id AS id_genero,
    b.nombre AS genero,
    c.id AS id_clase,
    c.nombre AS clase,
    d.id AS id_usuario,
    d.correo
FROM heroes a
    LEFT JOIN generos b ON a.id_genero = b.id
    LEFT JOIN clases c ON a.id_clase = c.id
    LEFT JOIN usuarios d ON d.id = a.id_usuario;

SELECT 0; 
INSERT INTO usuarios (correo, clave) VALUES ('netero@hxh.cl', '123456');
SELECT COUNT(id) FROM usuarios WHERE correo = 'netero@hxh.cl';
SELECT id FROM usuarios WHERE correo = 'netero@hxh.cl' AND clave = "123456";
SELECT id, correo, clave FROM usuarios;
SELECT id, nombre FROM generos;
SELECT id, nombre FROM clases;
SELECT id, nombre, id_genero, id_clase, id_usuario FROM heroes;
INSERT INTO heroes (nombre, id_genero, id_clase, id_usuario) VALUES ('', 0, 0, 0);

DROP TABLE heroes;
DROP TABLE clases;
DROP TABLE generos;
DROP TABLE usuarios;
```
# Desafio M5 Dia 14 MVC

### Dependencias
* [Link Repositorio](https://mvnrepository.com/)
```
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

<!-- PostreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>

<!-- MySQL -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>

<!-- BCrypt -->
<dependency>
    <groupId>org.mindrot</groupId>
    <artifactId>jbcrypt</artifactId>
    <version>0.4</version>
</dependency>
```

### MySQL
```
CREATE USER 'praxis'@'localhost' IDENTIFIED BY 'praxis';
GRANT CREATE, ALTER, DROP ON *.* TO 'praxis'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'praxis'@'localhost';
GRANT REFERENCES ON praxis.* TO 'praxis'@'localhost';

CREATE DATABASE praxis;
USE praxis;

-- DDL
CREATE TABLE proveedores (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE autos (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    url VARCHAR(256) NOT NULL,
    id_proveedor INT NOT NULL,
	CONSTRAINT fk_auto_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedores(id)
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    correo VARCHAR(50) NOT NULL,
    clave VARCHAR(255) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apodo VARCHAR(50) NOT NULL,
    peso INT NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_auto INT NOT NULL,
    CONSTRAINT fk_usuario_auto FOREIGN KEY (id_auto) REFERENCES autos(id)
);

CREATE TABLE direcciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    numero INT NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE usuarios_roles (
    id_usuario INT NOT NULL,
    id_rol INT NOT NULL,
    PRIMARY KEY (id_usuario, id_rol),
    CONSTRAINT fk_this_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    CONSTRAINT fk_this_roles FOREIGN KEY (id_rol) REFERENCES roles(id)
);

INSERT INTO proveedores 
    (nombre) 
VALUES 
    ('Toyota'), 
    ('Volkswagen'), 
    ('Ford'), 
    ('General Motors'), 
    ('Honda'), 
    ('Nissan'), 
    ('BMW'), 
    ('Mercedes-Benz'), 
    ('Hyundai'), 
    ('Kia');

INSERT INTO autos
    (nombre, url, id_proveedor)
VALUES     
   ('Toyota Corolla', 'Toyota_Corolla.jpg', 1),
   ('Volkswagen Golf', 'Volkswagen_Golf.jpg', 2),
   ('Ford Mustang', 'Ford_Mustang.jpg', 3),
   ('Chevrolet Camaro', 'Chevrolet_Camaro.jpg', 4),
   ('Honda Civic', 'Honda_Civic.jpg', 5),
   ('Nissan Altima', 'Nissan_Altima.jpg', 6),
   ('BMW Serie 3', 'BMW_Serie3.webp', 7),
   ('Mercedes-Benz Clase C', 'Mercedes-Benz_ClaseC.jpeg', 8),
   ('Hyundai Elantra', 'Hyundai_Elantra.jpg', 9),
   ('Kia Optima', 'Kia_Optima.jpg', 10);
   
INSERT INTO usuarios
    (correo, clave, nombre, apodo, peso, id_auto)
VALUES
    ('netero@hxh.cl', '123456', 'Isaac Netero', 'HxH', 69, 3),
    ('gon@hxh.cl', 'hunter2024', 'Gon Freecss', 'Gon', 58, 5),
    ('killua@hxh.cl', 'assassin123', 'Killua Zoldyck', 'Killua', 65, 1),
    ('kurapika@hxh.cl', 'chains444', 'Kurapika', 'Kurapika', 70, 7),
    ('leorio@hxh.cl', 'doctor99', 'Leorio Paradinight', 'Leorio', 85, 2),
    ('hisoka@hxh.cl', 'tricks555', 'Hisoka Morow', 'Hisoka', 80, 4),
    ('chrollo@hxh.cl', 'nen777', 'Chrollo Lucilfer', 'Chrollo', 75, 6),
    ('bisky@hxh.cl', 'trainer888', 'Biscuit Krueger', 'Bisky', 55, 9),
    ('kite@hxh.cl', 'hunter999', 'Kite', 'Kite', 90, 8),
    ('ging@hxh.cl', 'prohunter2024', 'Ging Freecss', 'Ging', 75, 10);

INSERT INTO roles
    (nombre)
VALUES
    ('Admin'),
    ('Trabajador');
    
INSERT INTO usuarios_roles
    (id_usuario, id_rol)
VALUES
	(1, 1),
    (2, 2),
    (3, 2),
    (4, 2),
    (5, 2),
    (6, 2),
    (7, 2),
    (8, 2),
    (9, 2),
    (10, 2);

INSERT INTO direcciones 
	(nombre, numero, id_usuario) 
VALUES
    ('Calle Siempre Viva', 742, 1),
    ('Avenida Libertador', 123, 2),
    ('Calle Falsa', 123, 3),
    ('Avenida Principal', 456, 4),
    ('Calle Secundaria', 789, 5),
    ('Boulevard Central', 101, 6),
    ('Avenida de los Héroes', 202, 7),
    ('Callejón Oscuro', 303, 8),
    ('Plaza de la Victoria', 404, 9),
    ('Calle de los Sueños', 505, 10);

SELECT COUNT(id) FROM usuarios WHERE correo = 'netero@hxh.cl' AND clave = '123456';
SELECT id, nombre, url, id_proveedor FROM autos;
SELECT 
	a.id, 
    a.correo, 
    a.clave, 
    a.nombre, 
    a.apodo, 
    a.peso, 
    a.fecha_creacion, 
    a.fecha_modificacion,
    a.id_auto,
    c.nombre AS rol,
    d.url
FROM usuarios a
	LEFT JOIN usuarios_roles b ON a.id = b.id_usuario
    LEFT JOIN roles c ON c.id = b.id_rol
    LEFT JOIN autos d ON d.id = a.id_auto
    LEFT JOIN address e ON e.id_uusario = a.id
ORDER BY a.id;

SELECT 
	a.id, 
    a.correo, 
    a.nombre, 
    a.apodo, 
    a.peso, 
    a.fecha_creacion, 
    a.fecha_modificacion,
    c.id AS idRol,
	c.nombre AS rol, 
    d.id AS idAuto,
    d.nombre AS auto,
    d.url,
    e.id AS idDireccion,
    e.nombre AS direccion,
    e.numero
FROM usuarios a 
	LEFT JOIN usuarios_roles b ON a.id = b.id_usuario
    LEFT JOIN roles c ON c.id = b.id_rol
    LEFT JOIN autos d ON d.id = a.id_auto
	LEFT JOIN direcciones e ON e.id_usuario = a.id
WHERE correo = 'netero@hxh.cl' AND clave = '123456';
SELECT id, nombre FROM roles;
SELECT id, nombre, numero, id_usuario FROM direcciones;

SELECT id, nombre, url, id_proveedor FROM autos;

DROP TABLE usuarios_roles;
DROP TABLE roles;
DROP TABLE direcciones;
DROP TABLE usuarios;
DROP TABLE autos;
DROP TABLE proveedores;
```


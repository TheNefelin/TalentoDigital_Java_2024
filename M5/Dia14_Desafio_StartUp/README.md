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
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    correo VARCHAR(50) NOT NULL,
    clave VARCHAR(255) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apodo VARCHAR(50) NOT NULL,
    peso INT NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP    
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
    CONSTRAINT fk_this_roles FOREIGN KEY (id_usuario) REFERENCES roles(id)
);

CREATE TABLE proveedores (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE autos (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    url VARCHAR(256) NOT NULL,
    id_usuario INT NOT NULL,
    id_proveedor INT NOT NULL,
    CONSTRAINT fk_auto_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	CONSTRAINT fk_auto_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedores(id)
);

INSERT INTO usuarios
    (correo, clave, nombre, apodo, peso)
VALUES
    ('netero@hxh.cl', '123456', 'Isaac Netero', 'HxH', 69);

INSERT INTO roles
    (nombre)
VALUES
    ('Admin'),
    ('Trabajador');
    
INSERT INTO usuarios_roles
    (id_usuario, id_rol)
VALUES
    (1, 1); 
   
SELECT id, correo, clave, nombre, apodo, peso, fecha_creacion, fecha_modificacion FROM usuarios;
SELECT id, nombre, numero, id_usuario FROM direcciones;
SELECT id, nombre FROM roles;
SELECT id_usuario, id_rol FROM usuarios_roles;
SELECT COUNT(*) FROM usuarios WHERE correo = 'netero@hxh.cl' AND clave = '123456';

DROP TABLE usuarios_roles;
DROP TABLE autos;
DROP TABLE direcciones;
DROP TABLE roles;
DROP TABLE usuarios;
DROP TABLE proveedores;
```


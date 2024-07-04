# Desafio M5 Dia 11 Proveedores

### Matar Puerto si esta tomado
```
cmd
netstat -ano
taskkill /pid <pid number> /f
```

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

<!--JSPL => <%@ taglib prefix="c" uri="jakarta.tags.core" %> -->
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
```

### MySQL
```
CREATE USER 'praxis'@'localhost' IDENTIFIED BY 'praxis';
GRANT CREATE, ALTER, DROP ON *.* TO 'praxis'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'praxis'@'localhost';

CREATE DATABASE praxis;
USE praxis;

CREATE TABLE proveedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    rut VARCHAR(11) NOT null,
    direccion VARCHAR(100) NOT null,
    correo VARCHAR(50) NOT null,
    telefono VARCHAR(15) NOT null,
    contacto VARCHAR(50) NOT null,
    telefono_contacto VARCHAR(15) NOT null
);

SELECT * FROM proveedores;
```

### PostgreSQL
```
```

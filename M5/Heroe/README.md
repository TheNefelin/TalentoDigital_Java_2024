# Ejercitando

### Matar Puerto si esta tomado
```
cmd
netstat -ano
taskkill /pid <pid number> /f
```

### Dependencias
* [Link Repositorio](https://mvnrepository.com/)
```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>

// En el JSP => <%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

// PostreSQL
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>

// MySQL
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```

### MySQL crear usuario
```
CREATE USER 'praxis@localhost' IDENTIFIED BY 'praxis';

GRANT CREATE, ALTER, DROP  
ON praxis.* TO 'praxis@localhost';

GRANT SELECT, INSERT, UPDATE, DELETE  
ON praxis.* TO 'praxis@localhost';
```

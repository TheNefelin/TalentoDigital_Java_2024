# Desafio Dia05 - Hotel Sheraton

### Dependency
```
// Para impementar los JSTL
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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

// Ahorra codgo en los objetos
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>
```

### Injectar Componentes html
```
<%@include file="assets/html/head.jsp"%>
```

### accent issue
```
// in every jsp add..
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
```
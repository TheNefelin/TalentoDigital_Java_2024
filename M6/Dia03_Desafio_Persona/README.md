# Desafio Dia 03 M6 Persona

Empaquetado JAR es para Java <br>
Empaquetado WAR es para Web

[Spring Boot Samples](https://spring.io/projects/spring-boot#samples) <br>
[Spring Boot Initializr](https://start.spring.io/)

### Preparing project
* Java
* Maven
* JDK and Java 21
* Packaging War (for web)

### Dependency, Spring Boot: 3.3.2 (SNAPSHOT)
- Developer Tools:
    * Spring Boot DevTools
    * Lombok
- Web:
    * Spring Web
    * Rest Repositories
    * Spring Web Services
- Template Engines:
    * Thymeleaf
- SQL:
    * Spring Data JPA
    * MySql Driver

### Folder
```
/
├── main/
│   ├── java/
│   │   └── packages/
│   │      ├── config/
│   │      ├── controllers/
│   │      ├── entities/
│   │      ├── repositories/
│   │      ├── services/
│   │      ├── App.java
│   │      └── ServletInitializer.java
│   └── resources/
└── test/
```

### Config DB
* resource => application.properties
```
spring.mvc.view.prefix=/templates/

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/praxis?useSSL=false&serverTimezone=UTC
spring.datasource.username=praxis
spring.datasource.password=praxis
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Hibernate Configuration
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
```

### TaskKill
```
cmd
netstat -ano
taskkill /pid <pid-number> /f
```

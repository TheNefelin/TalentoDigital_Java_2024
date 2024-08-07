# Desafio Dia 06 M6 Biblioteca

Empaquetado JAR es para Java <br>
Empaquetado WAR es para Web

[Spring Boot Samples](https://spring.io/projects/spring-boot#samples) <br>
[Spring Boot Initializr](https://start.spring.io/)

### Preparing project
* Java
* Maven
* JDK and Java 21
* Packaging War (for web)

### Dependency, Spring Boot: 3.4.0 (SNAPSHOT)
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
│   │      ├── controllers/
│   │      ├── entities/
│   │      ├── repositories/
│   │      ├── services/
│   │      ├── App.java
│   │      └── ServletInitializer.java
│   └── resources/
│          ├── static/
│          └── templates/
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

### Config MVC
* resource => application.properties
```
# Enable PUT and DELETE in MVC
spring.mvc.hiddenmethod.filter.enabled=true
```

### Config Error Template
* resource => application.properties
```
# Custom Error Controller
server.error.whitelabel.enabled=false
server.error.path=/error
```
* Create error404.html
* Create Custom Error Controller
```
@Controller
public class CustomErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == 404) {
                return "error404";
            }
        }

        return "error404";
    }
}
```

### Loggers
```
// import org.springframework.boot.CommandLineRunner;
// implements CommandLineRunner 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private final static Logger LOG = LoggerFactory.getLogger(App.class);

@Override
public void run(String... args) throws Exception {
  LOG.info("Se Inicio el Software");
  
  LOG.info("Mensaje Informativo");
  LOG.warn("Mensaje de Advertencia");
  LOG.error("Mensaje de Error");
}
```

### Example using Thunder Client
```
[
  {
    "id": 1,
    "title": "El Hobbit",
    "author": "J.R.R. Tolkien",
    "publisher": "George Allen & Unwin"
  },
  {
    "id": 2,
    "title": "El Silmarillion",
    "author": "J.R.R. Tolkien",
    "publisher": "George Allen & Unwin"
  },
  {
    "id": 3,
    "title": "La Rueda del Tiempo: El Ojo del Mundo",
    "author": "Robert Jordan",
    "publisher": "Tor Books"
  },
  {
    "id": 4,
    "title": "Canción de Hielo y Fuego: Juego de Tronos",
    "author": "George R. R. Martin",
    "publisher": "Bantam Books"
  }
]
```

### TaskKill
```
cmd
netstat -ano
taskkill /pid <pid-number> /f
```

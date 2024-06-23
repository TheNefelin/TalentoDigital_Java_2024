# Jakarta EE

### Resource
* [IntelliJ](https://www.jetbrains.com/idea/)
* [Java SDK 21](https://www.oracle.com/java/technologies/downloads/)
* [Tomcat](https://tomcat.apache.org/download-10.cgi) (Linux: core tar.gz, win: core 64-bit-windows zip)

### Projects list
- [Jakarta Rest]() (API)
- [Jakarta Demo WebApp]() (Web Application)
- [Jakarta FirstWebProject]() (Web Application)
- [Jakarta ActividadJSP]() (Web Application)
- [Jakarta DesafioJSP]() (Web Application)
- [Jakarta EjercicioJSTL]() (Web Application)

### New project
- Jakarta EE
- Web Aplication / REST service
- Tomcat Server 10..
- Java and Maven
- Jakarta EE 10
- Specifications: Full Platform
- Implementations: Exlipse Jersey Server
- run

> [!NOTE]
> Some Concepts
* JEE: Oracle (Java Enterprise Edition)
* Jakarta EE: Eclipse Foundation (Jakarta Enterprise Edition)
* JSP: Java Server Page (Front of Back)
* Servlet: Backend code and JSP: Frontend Code

> [!WARNING]
> Jakarta EE only works with Tomcat 10 or higher, JEE only works with previous versions of Tomcat

### Pom Dependency
* For JSTL for JSP
```
// jsp
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

// pom
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
```

<hr>
<hr>
<hr>

```
```

> [!NOTE]  
> Highlights information that users should take into account, even when skimming.

> [!TIP]
> Optional information to help a user be more successful.

> [!IMPORTANT]  
> Crucial information necessary for users to succeed.

> [!WARNING]  
> Critical content demanding immediate user attention due to potential risks.

> [!CAUTION]
> Negative potential consequences of an action.
# Java and Maven

### Projects list
- [Ejercicios Maven](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Ejercicios_Maven)
    * Futbol
    * Personas
- [Desafio Dia03 Resistencia](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia03_Resistencia) (Java)
- [Desafio Dia06 Edades](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia06_Edades) (Java)
- [Desafio Dia09 While por DoWhile](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia09_WhilePorDoWhile) (Java)
- [Desafio Dia12 Patrones](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia12_Patrones) (Java)
- [Desafio Dia15 Operando con Arreglos](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia15_OperandoConArreglos) (Java)
- [Desafio Dia18 Escritura y Lectura](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia18_EscrituraLectura) (Java)
- [Desafio Dia20 Automotora](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia20_Automotora) (Java)
- [Desafio Dia21 Automotora2](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia21_Automotora2) (Java)
- [Desafio Dia23 Automotora3](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia23_Automotora3) (Java)
- [Desafio Dia25 Manejo de Excepciones](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia25_ManejoExcepciones) (Java)
- [Desafio Dia27 Indiana Jeans](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia27_IndianaJeans) (Java)
- [Desafio Dia28 Recicla Jeans](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia28_ReciclaJeans) (Java)
- [Desafio Dia30 Mirando el Pasado](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia30_MirandoElPasado) (Java)
- [Desafio Dia32 Calculadora](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia32_Calculadora) (Maven)
- [Desafio Dia33 Calculadora2](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Desafio_Dia34_Calculadora2) (Maven)
- [Prueba Dia36 Sistema de Clientes](https://github.com/TheNefelin/TalentoDigital_Java_2024/tree/main/M4/Prueba_Maven_SistemaDeClientes) (Maven)


### Maven
* Gestor de paquetes, las dependencias se agregan en el pom.xml
* [Repositorio](https://mvnrepository.com/)

### Dependencias
1.- Junit dependencia para test unitarios
```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```
```
@DisplayName("Tests Clase ServicioPersona")
public class ServicioPersonaTest {

    private static Logger logger = Logger.getLogger("cl.desafiolatam.servicios.ServicioPersonaTest");
    private final ServicioPersona servicioPersona = new ServicioPersona();

    @Test
    public void testCrearPersona() {
        logger.info("info test crear persona");
        Persona juanito = new Persona("1234-1", "Juanito");
        String respuestaServicio = servicioPersona.crearPersona(juanito);
        assertEquals("Creada", respuestaServicio);
    }
}
```
* @BeforeEach = el metodo se ejecuta antes de todas las pruebas, se inicializan objetos, debe ser void, no debe ser privado y deben ser estatico.
```
@BeforeAll
static void setup() {
    logger.info("Inicio clase de prueba");
}
```
* @BeforeAll = el metodo se ejecuta antes de cada metodo @Test, debe ser void, no debe ser privado y no debe ser estatico.
```
@BeforeEach
void init() {
    logger.info("Inicio metodo de prueba");
}
```
* @AfterEach = el metodo se ejecuta despues de cada metodo @Test, debe ser void, no debe ser privado y no debe ser estatico.
```
@AfterEach
void tearDown() {
    logger.info("Metodo de prueba finalizado");
}
```
* @AfterAll = el metodo se ejecuta despues de todas las pruebas, se liberan los objetos crados, debe ser void, no debe ser privado y debe ser estatico.
```
@AfterAll
static void done() {
    logger.info("Fin clase de prueba");
}
```

2.- Lombok nos ahorra codigos implementando directivas
```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>
```
> Ejem: @Setter @Getter @ToString @NoArgsConstructor

3.- Mockito pruebas dobles
```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>
```
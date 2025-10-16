# Wompi QA Automation - Pruebas API PSE

## Framework de automatización para pruebas de API de Wompi implementando BDD con Cucumber y Page Object Model para APIs.

## Tecnologías
- Java 17 LTS
- Cucumber (BDD)
- RestAssured
- Maven
- JUnit 5

## Arquitectura

src/test/java/co/com/wompi/
├── models/ # DTOs
├── clients/ # Clientes HTTP
├── stepdefinitions/ # Steps BDD
└── runners/ # Ejecución


## Ejecución
```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar todas las pruebas
mvn test

# Ejecutar con reportes detallados
mvn test -Dcucumber.plugin="html:target/detailed-reports.html"

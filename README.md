# Automatización QA FrontEnd - Sauce Demo

Suite de pruebas automatizadas End-to-End (E2E) para la aplicación web [Sauce Demo](https://saucedemo.com), desarrollada con **Java**, **Playwright** y **Cucumber (BDD)**.

## Requisitos Previos
* **Java JDK 17** o superior.
* **Apache Maven 3.8+** (o el wrapper incluido en IntelliJ IDEA).
* Conexión a internet (la primera ejecución descarga automáticamente los binarios de Chromium).

## Estructura del Proyecto
```text
src/test
 ├── java
 │    ├── hooks           # Gestión del ciclo de vida del navegador (Playwright)
 │    ├── pages           # Clases Page Object Model (Login, Products, Cart, Checkout)
 │    ├── runner          # Ejecutor principal de Cucumber con JUnit
 │    └── stepdefinitions # Implementación en Java de los pasos Gherkin
 └── resources
      └── features        # Escenarios de prueba escritos en lenguaje Gherkin
```

## Instrucciones de Ejecución
1. Clonar el repositorio:
   ```bash
   git clone <URL_DE_TU_REPOSITORIO>
   cd saucedemo-playwright-cucumber
   ```
2. Ejecutar las pruebas desde terminal con Maven:
   ```bash
   mvn test
   ```
   *(También se puede ejecutar directamente desde IntelliJ haciendo clic en Run sobre `src/test/java/runner/TestRunner.java`)*.
3. Visualizar el reporte generado al finalizar:
   Abrir el archivo `target/cucumber-reports.html` en cualquier navegador web.

---

## Informe Breve: Estrategia de Automatización y Patrones Utilizados

### 1. Estrategia de Pruebas
La estrategia se enfoca en validar los flujos críticos de negocio (Smoke & E2E) mediante **Behavior-Driven Development (BDD)**, separando la especificación funcional de la implementación técnica. Se cubrieron tanto caminos felices (compra completa con `standard_user`) como escenarios negativos de control de acceso (`locked_out_user` y credenciales inválidas).

### 2. Patrones de Diseño Implementados
* **Page Object Model (POM):** Cada vista de la aplicación (`LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`) está encapsulada en su propia clase. Esto centraliza los selectores web y las interacciones, evitando duplicación de código y facilitando el mantenimiento si la interfaz cambia.
* **Hooks / Singleton de Contexto:** Mediante las anotaciones `@Before` y `@After` de Cucumber en la clase `Hooks`, se garantiza que cada escenario se ejecute en un contexto de navegador limpio e independiente, evitando contaminación de estado entre pruebas.

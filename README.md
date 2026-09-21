# Pruebas automatizadas QA

Proyecto de automatizacion web y API con **Java**, **Maven**, **Serenity BDD**, **Screenplay** y **Cucumber**.

## Alcance

- **Web:** Selenium Dev, navegacion a Documentation y busqueda por WebDriver.
- **API:** listado, creacion y actualizacion de usuarios en ReqRes.
- Los escenarios API utilizan `Scenario Outline` y `Examples` para parametrizar cada caso de prueba.

## Requisitos

- Java 11 o superior.
- Maven 3.8 o superior.
- Google Chrome instalado.
- Conexion a internet para acceder a `https://selenium.dev` y `https://reqres.in`.

El proyecto usa WebDriverManager para gestionar ChromeDriver automaticamente.

## Configuracion

1. Clonar el repositorio:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd Reto_Tecnico
   ```

2. Verificar las versiones instaladas:

   ```bash
   java -version
   mvn -version
   ```

3. Revisar `serenity.properties` si se requiere cambiar el navegador, las URLs o la ruta de salida de los reportes.

## Ejecucion

Ejecutar todas las pruebas y generar el reporte:

```bash
mvn clean verify
```

Ejecutar la suite de Cucumber:

```bash
mvn test
```

El comando puede ejecutarse desde la raiz del proyecto.

### Ejecucion por tags

El runner ejecuta los escenarios con las etiquetas `@AUTOMATION_WEB` y
`@AUTOMATION_API`. Para ejecutar una suite especifica:

```bash
mvn -Dtest=RunnerTest -Dcucumber.filter.tags="@AUTOMATION_API" test
mvn -Dtest=RunnerTest -Dcucumber.filter.tags="@AUTOMATION_WEB" test
```

Para ejecutar un caso individual:

```bash
mvn -Dtest=RunnerTest -Dcucumber.filter.tags="@CASO_API_1" test
```

La ejecución está configurada de forma secuencial: se ejecuta un escenario,
termina y luego comienza el siguiente. Para ejecutar los tres casos web:

```bash
mvn -Dtest=RunnerTest -Dcucumber.filter.tags="@AUTOMATION_WEB" test
```

## Reportes Serenity BDD

Despues de ejecutar las pruebas, abrir:

```text
target/site/serenity/index.html
```

El directorio `target/` es generado por Maven y esta excluido del repositorio. Para compartir el reporte, publicar `target/site/serenity` como artefacto de CI o mediante GitHub Pages.

### Enlaces del entregable

Completar estos enlaces despues de crear el repositorio remoto y publicar el reporte:

- **Repositorio:** `<URL_PUBLICA_DEL_REPOSITORIO>`
- **Reporte Serenity BDD:** `<URL_PUBLICA_DEL_REPORTE_SERENITY>`
- **Reporte local:** `target/site/serenity/index.html`

## Estructura principal

```text
src/test/resources/features/        Escenarios Gherkin
src/test/java/com/example/runner/   Runner de Cucumber + Serenity
src/test/java/com/example/tasks/    Tasks de Screenplay
src/test/java/com/example/questions/ Validaciones
src/test/java/com/example/api/      Tasks para ReqRes
target/site/serenity/               Reporte HTML generado
```

## Publicar el reporte

1. Ejecutar `mvn clean verify`.
2. Publicar la carpeta `target/site/serenity` en el servicio de CI elegido.
3. Copiar la URL publica generada en `URL_PUBLICA_DEL_REPORTE_SERENITY`.
4. Copiar la URL del repositorio en `URL_PUBLICA_DEL_REPOSITORIO`.

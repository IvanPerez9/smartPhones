![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)

# Prueba técnica

- Prueba redactada en el archivo adjunto dentro de la carpeta "info"
- Código dentro de la carpeta "smartphoneApp"

#### Índice

1. [Prueba Técnica](#Prueba-tecnica)
2. [Tecnologías](#Tecnologías)
3. [Iniciar el proyecto](#Iniciar-el-proyecto)
4. [Ejecutar los test](#Ejecutar-los-test)
5. [Detalles](#Detalles-sobre-el-proyecto)

---
## Tecnologías

- Java 17 y Springboot 3.1.5
- Eclipse - STS 4.21
- Plugins:
    - Jautodoc 1.16.0
    - SonarLint 9.3.0
    - EclEmma Java code coverage 3.1.8
- Mockito
- JUnit 5

---
## Iniciar el proyecto

Clonar el repositorio

```
git clone https://github.com/IvanPerez9/smartPhones
```

Importar la carpeta 'smartphoneApp' en eclipse o el IDE de preferencia.

Importar dentro de Eclipse:

File -&gt; Import -&gt; Existing Maven projects -&gt; Seleccionar el proyecto, detectará el pom automáticamente

Dentro de eclipse, usar botón derecho 'Run As' o 'Debug As' para levantar. Se levantará sobre el puerto 5000 como se pedia.
Esta configuración se puede editar en el "application.properties" dentro de Resources.

---
## Ejecutar los test

Apoyar con el plugin y poder lanzar un 'Coverage as'

![coverage](https://github.com/IvanPerez9/smartPhones/blob/main/info/assets/CoverageLanzar.png)

También se puede mediante el comando

```
mvn clean install
```

![consola](https://github.com/IvanPerez9/smartPhones/blob/main/info/assets/consola.png)

---
## Detalles sobre el proyecto

- Como ORM uso JPA, ya que me facilita las queries a la BBDD embebida como H2. Se encarga de transformar los objetos java en sentencias SQL.

- El rango para el calculo de los precios y la moneda por defecto, la pongo por configuración, ya que si se quiere cambiar, es más facil cambiarlo de esta forma. (application.yml)

- Se hacen 3 endpoint, aunque el cliente solo consuma 1. Así se puede probar cada parte por separado, y en el swagger se puede solo exponer el necesario.

- Se saca una colección de postman para probar los endpoint no solo con los test. Colección de Postman para realizar las pruebas:
    -   [Postman]([https://github.com/IvanPerez9/smartPhones](https://github.com/IvanPerez9/smartPhones/tree/main/postman))

- Como patrón, usando springboot está presente la inyección de dependencias. La inyección de las dependencias las hago mediante constructor, ya que es la recomendada para la mayoría de casos, aunque podría haber sido por campo, ya que el ejemplo es básico.

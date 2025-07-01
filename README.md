# Catalog

Esta es la resolución al ejercicio propuesto de devolver el precio correcto ante una petición que incluye:
- Un id de marca
- Un id de producto
- Una fecha

Para este ejercicio se ha considerado que todos estos campos son obligatorios y en caso de faltar uno la aplicación responderá
con un código HTTP 400 Bad Request.

La aplicación responderá devolviendo los siguientes campos:
- El id de la marca
- El id del producto
- El id de la tarifa de precios aplicable
- Las fechas en las que se aplica el precio
- El precio final

Se ha considerado que el id de la tarifa de precios aplicable correspondería a la clave primaria de la tabla prices. En caso 
de que esta suposición sea incorrecta se debería crear un nuevo campo para la clave primaria.

En caso de que la aplicación no encuentre el precio indicado en la petición, esta responderá devolviendo un código HTTP
404 Not Found. Para más detalles acerca del funcionamiento del endpoint hay un openapi incluido en la carpeta resources del proyecto

## Tecnologías Usadas
Para este proyecto se ha utilizado las siguientes tecnologías:
- Java 17
- Spring Boot 3.5.3
- Lombok
- OpenApi Generator para generar las API que implementan los controladores y los objetos que devuelven
- MapStruct para crear los mapper
- H2 como base de datos relacional
- Hibernate como ORM
- JUnit para los test

## Arquitectura del proyecto
Se ha seguido una arquitectura hexagonal para el desarrollo de este proyecto en el que las distintas capas están divididas en paquetes. 
En concreto, estos paquetes son:
- Application: que contiene la lógica de negocio (los casos de uso) y por tanto tiene la implementación del servicio
- Domain: donde se encuentra el modelado el negocio. En nuestro caso, los modelos y nuestros puertos
- Infrastructure: que es la capa donde se encuentra todo lo dependiente con tecnología. En este proyecto comprendería de:
  - Api: donde estaría la API REST con un REST endpoint. 
  - Persistence: donde se realiza la conexión y las operaciones sobre la base de datos con una implementación de JPA.

En esta arquitectura hay un orden de dependencias de tal manera que:
- La capa Infrastructure depende de la capa Domain y Application
- La capa Application depende de la capa Domain
- La capa Domain no depende de ninguna

Si se quisiera tener más control en el orden de las dependencias para evitar su incumplimiento, en vez de dividir las 
capas en paquetes se pueden dividir las distintas capas en módulos Java. 

Para este proyecto se ha tenido también en cuenta un enfoque API FIRST en el que se tiene que realizar la especificación de las
API antes del desarrollo del código. Para seguir este enfoque se ha utilizado el OpenApi Generator. Este generador genera a partir 
de una especificación openapi las interfaces que deben implementar los controladores y los objetos de salida como de entrada de la API.
De esta manera se empuja a actualizar el openapi del proyecto y a especificarlo antes de realizar el desarrollo de un endpoint.

## Arranque del proyecto
Se debe compilar el proyecto en Java 17 y después lanzar como cualquier proyecto spring boot en tu IDE preferido o 
directamente con un comando maven. Al compilar el proyecto, mapstruct generará la implementación de los mappers y openapi
generator generará el código de las API y los objetos que usarán los controladores. 

Al arrancar el proyecto se cargarán los datos en la base en memoria H2. Si se quisiera acceder a esta base de datos se puede realizar desde:

http://localhost:8080/h2-console

La JDBC URL la indica spring en los logs. El usuario por defecto es **sa** y no tiene contraseña.
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
404 Not Found. Para más detalles acerca del funcionamiento del endpoint se ha incluido un openapi dentro de la carpeta docs
de este proyecto.

## Arquitectura del proyecto
Se ha seguido una arquitectura hexagonal para el desarrollo de este proyecto en el que las distintas capas están divididas en paquetes. 
En concreto, estos paquetes son:
- Application: que sería la capa expuesta y donde se encuentran los endpoints
- Domain: donde se encuentra la lógica de negocio
- Infrastructure: que en nuestro caso es la encargada de conectarse a la base de datos

La capa Application e Infrastructure se conecta a la capa Domain mediante los puertos de este. De esta manera, la capa domain 
queda completamente aislada. 

Si se quisiera aislar más la capa Domain, en vez de dividir las capas en paquetes se pueden dividir las distintas capas en
módulos Java. En los que la capa Application e Infrastructure se conecten con Domain pero no al reves, evitando que puedan
ocurrir incumplimientos de la arquitectura durante un desarrollo.

## Tecnologías Usadas
Para este proyecto se ha utilizado las siguientes tecnologías:
- Java 17
- Spring Boot 3.5.3
- Lombok
- MapStruct para crear los mapper
- Como ORM Hibernate
- Como base de datos H2

## Arranque del proyecto
Se debe compilar el proyecto en Java 17 y después lanzar como cualquier proyecto spring boot en tu IDE preferido o 
directamente con un comando maven
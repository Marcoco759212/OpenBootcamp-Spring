## Spring boot

Proyecto Spring boot con las dependencias / starters:
* H2
* Spring Data JPA
* Spring Web
* Spring boot dev tools
* spring-boot-starter-validation (se usó ya que se generaba un error el cual se solucionó con esta dependencia)
* OpenApi (usado por que la dependencia de SpringFox no funcionó)

Aplicacion API REST con acceso a base de datos H2 para persistir la informacion.

El acceso se puede realizar desde Postman o Navegador.

## Entidad Book

1. Book
2. BookRepository
3. BookController
	1. Buscar todos los libros
	2. Buscar un libro por Id
	3. Crear un nuevo libro
	4. Actualizar los datos d eun libro
	5. Borrar un libro
	6. Borrar todos los libros
	
Las siguientes propiedades sirven para no exponer la informacion de los errores cuando se consultan los servicios
* server.error.include-message=never
* server.error.include-stacktrace=never

## Testing
Se hace testing de la clase BookControllerTest con JUnit en los metodos 

* hello
* testFindAll
* testFindOneById
* testCreateBook




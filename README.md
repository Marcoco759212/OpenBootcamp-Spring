## Ejercicios de los videos

### Spring boot

Proyecto Spring boot con las dependencias / starters:
* H2
* Spring Data JPA
* Spring Web
* Spring boot dev tools
* spring-boot-starter-validation (se usó ya que se generaba un error el cual se solucionó con esta dependencia)
* OpenApi (usado por que la dependencia de SpringFox no funcionó)

Aplicacion API REST con acceso a base de datos H2 para persistir la informacion.

El acceso se puede realizar desde Postman o Navegador.

### Entidad Book

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

### Testing
Se hace testing de la clase BookControllerTest con JUnit en los metodos 

* hello
* testFindAll
* testFindOneById
* testCreateBook

### Despliegue de apps Spring Boot en Heroku

Crear archivo `System.properties` en el proyecto con el contenido:

``` 
java.runtime.version=17 

```

1. Crear cuenta en heroku.com y github.com
2. Tener configurado git en el ordenador:\
	1. `git config --global user.name "nombre de usuario"`
	2. `git config --global user.email correo del usuario`
3. Subir el proyecto a GitHub
4. Desde Heroku, crear app y elegir método GitHub y buscar el repositorio subido
5. Habilitar deploy automático y ejecutar el deploy


### Configuracion de archivos.properties

Se crean archivos de propiedades en los cuales se pueden declarar variables ue depues se pueden leer desde codigo, se crean perfiles de propiedades que se pueden utilizar para definir el entorno en el que se quiere desplegar la aplicaci[on


### Configuracion de Spring Security

Se agregan las dependencias de Spring Security y la clase de configuración WebSecurityConfig para agregar autenticaci[on basica de Http con usuario y contraseña, en este paso se tuvo que buscar la manera en hacer que funcionara correctamente ya que los ejemplos del curso ya son obsoletos.

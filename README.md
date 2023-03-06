## Ejercicios 10, 11 y 12

### Ejercicio 1

Probar a empaquetar la aplicación con maven package desde Intellij IDEA

Desde terminal en Intellij IDEA verificar que se se ejecuta correctamente con el comando: 

```
java -jar target/spring-deploy-1.0.jar

```

Crear un perfil para dev y otro para test con una propiedad nueva que carguemos en el controlador.

##### Evidencias Ejercicio 1

```

HP@DESKTOP-I4D2JCQ MINGW64 ~/Documents/workspace-sts-4.0/OB-Spring-Ejercicios (OB/Spring/Ejercicios101112)
$ java -jar target/OB-Spring-Ejercicios-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.2)

2023-03-04T13:57:54.577-06:00  INFO 6740 --- [           main] com.mahr.Main                            : Starting Main v0.0.1-SNAPSHOT using Java 17.0.2 with PID 6
740 (C:\Users\HP\Documents\workspace-sts-4.0\OB-Spring-Ejercicios\target\OB-Spring-Ejercicios-0.0.1-SNAPSHOT.jar started by HP in C:\Users\HP\Documents\workspace-st
s-4.0\OB-Spring-Ejercicios)
2023-03-04T13:57:54.585-06:00  INFO 6740 --- [           main] com.mahr.Main                            : The following 1 profile is active: "dev"
2023-03-04T13:57:56.008-06:00  INFO 6740 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode
.
2023-03-04T13:57:56.103-06:00  INFO 6740 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 81 ms. Found 1
 JPA repository interfaces.
2023-03-04T13:57:57.263-06:00  INFO 6740 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-03-04T13:57:57.280-06:00  INFO 6740 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-03-04T13:57:57.281-06:00  INFO 6740 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.5]
2023-03-04T13:57:57.425-06:00  INFO 6740 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-03-04T13:57:57.427-06:00  INFO 6740 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 27
49 ms
2023-03-04T13:57:57.665-06:00  INFO 6740 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-03-04T13:57:57.985-06:00  INFO 6740 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:c7d
449f8-98fa-48ab-9480-aedb6ce713fe user=SA
2023-03-04T13:57:57.987-06:00  INFO 6740 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-03-04T13:57:58.061-06:00  INFO 6740 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2023-03-04T13:57:58.154-06:00  INFO 6740 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.1.6.Final
2023-03-04T13:57:58.440-06:00  WARN 6740 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persist
ence.sharedCache.mode], use [jakarta.persistence.sharedCache.mode] instead
2023-03-04T13:57:58.660-06:00  INFO 6740 --- [           main] SQL dialect                              : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2023-03-04T13:57:59.613-06:00  INFO 6740 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernat
e.engine.transaction.jta.platform.internal.NoJtaPlatform]
2023-03-04T13:57:59.623-06:00  INFO 6740 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 
'default'
2023-03-04T13:58:00.050-06:00  WARN 6740 --- [           main] o.s.security.core.userdetails.User       : User.withDefaultPasswordEncoder() is considered unsafe for
 production and is only intended for sample applications.
2023-03-04T13:58:00.190-06:00  WARN 6740 --- [           main] o.s.security.core.userdetails.User       : User.withDefaultPasswordEncoder() is considered unsafe for
 production and is only intended for sample applications.
2023-03-04T13:58:00.485-06:00  WARN 6740 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, 
database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-03-04T13:58:01.663-06:00  WARN 6740 --- [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (plea
se add some templates, check your Thymeleaf configuration, or set spring.thymeleaf.check-template-location=false)
2023-03-04T13:58:02.057-06:00  INFO 6740 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security
.web.session.DisableEncodeUrlFilter@642857e0, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@4c6b4ed7, org.springframework.
security.web.context.SecurityContextHolderFilter@1943c1f2, org.springframework.security.web.header.HeaderWriterFilter@163042ea, org.springframework.security.web.csr
f.CsrfFilter@58af5076, org.springframework.security.web.authentication.logout.LogoutFilter@3aaa3c39, org.springframework.security.web.authentication.UsernamePasswor
dAuthenticationFilter@2db33feb, org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@76544c0a, org.springframework.security.web.authe
ntication.ui.DefaultLogoutPageGeneratingFilter@21263314, org.springframework.security.web.authentication.www.BasicAuthenticationFilter@60990e5c, org.springframework
.security.web.savedrequest.RequestCacheAwareFilter@1e1eeedd, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@7ec95456, org.sprin
gframework.security.web.authentication.AnonymousAuthenticationFilter@6ca30b8a, org.springframework.security.web.access.ExceptionTranslationFilter@2954f6ab, org.spri
ngframework.security.web.access.intercept.AuthorizationFilter@d902300]
2023-03-04T13:58:02.080-06:00  WARN 6740 --- [           main] o.s.s.c.a.web.builders.WebSecurity       : You are asking Spring Security to ignore Mvc [pattern='/ho
la']. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
2023-03-04T13:58:02.081-06:00  INFO 6740 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will not secure Mvc [pattern='/hola']
2023-03-04T13:58:02.176-06:00  INFO 6740 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '
'
2023-03-04T13:58:02.207-06:00  INFO 6740 --- [           main] com.mahr.Main                            : Started Main in 8.318 seconds (process running for 9.184)
2023-03-04T13:58:07.675-06:00  INFO 6740 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-03-04T13:58:07.675-06:00  INFO 6740 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-03-04T13:58:07.677-06:00  INFO 6740 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2023-03-04T13:58:07.912-06:00  INFO 6740 --- [nio-8080-exec-1] com.mahr.controllers.LaptopController    : #########Ambiente Desarrollo#########
2023-03-04T13:58:07.913-06:00  INFO 6740 --- [nio-8080-exec-1] com.mahr.controllers.LaptopController    : Consultando lista de laptops


```


### Ejercicio 2

Desplegar el API REST de Laptops en Heroku y verificar funcionamiento desde POSTMAN.

Se hizo el despliegue en un sitio llamado Rednder como contenedor de docker ya que actualmente no está desponible el sitio Heroku de forma gratuita

URL para consultar Laptops [https://ob-springboot.onrender.com/api/laptops](https://ob-springboot.onrender.com/api/laptops)


### Ejercicio 3

Añadir Spring Security sobre el proyecto API REST de Laptops y configurar 2 usuarios en memoria utilizando una clase WebSecurityConfig.

**Credenciales para basic auth**

```
User: user
Password: user

User: admin
Password: admin
```

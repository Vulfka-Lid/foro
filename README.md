ForoHub - Alura Challenge Backend 🚀
ForoHub es una API REST desarrollada en Java con Spring Boot para gestionar un foro de discusión. El proyecto implementa un sistema completo de tópicos donde los usuarios autenticados pueden crear, listar, actualizar y eliminar dudas sobre diversos cursos.

🛠️ Tecnologías utilizadas
Java 25 (OpenJDK)

Spring Boot 4.0.3

Spring Security (Autenticación y Autorización)

JWT (JSON Web Token para stateless sessions)

Spring Data JPA (Persistencia de datos)

Flyway (Migraciones de base de datos)

MySQL (Almacenamiento en el litio)

Lombok (Productividad con anotaciones)

Validation (Validación de datos de entrada)

🔐 Seguridad y Autenticación
La API utiliza un esquema de seguridad Stateless. Para acceder a los recursos protegidos (Tópicos), el usuario debe:

Realizar un login exitoso en /login.

Obtener el token JWT generado.

Incluir dicho token en el header Authorization como Bearer <token> en cada petición.

📌 Funcionalidades (Endpoints)
🔑 Autenticación
POST /login: Recibe credenciales y devuelve el token JWT.

📝 Tópicos
POST /topicos: Registra un nuevo tópico (requiere autenticación).

GET /topicos: Lista todos los tópicos activos con paginación y ordenamiento.

GET /topicos/{id}: Detalle de un tópico específico.

PUT /topicos: Actualiza el título y el mensaje de un tópico (solo campos permitidos).

DELETE /topicos/{id}: Realiza un borrado lógico desactivando el tópico sin eliminarlo de la base de datos.

🚀 Cómo ejecutar el proyecto
Clonar el repositorio:

Bash
git clone https://github.com/Vulfka-Lid/foro.git
Configurar la Base de Datos:

Crea una base de datos llamada foro en MySQL.

Ajusta las credenciales en src/main/resources/application.properties:

Properties
spring.datasource.url=jdbc:mysql://localhost/foro
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
Ejecutar la aplicación:

Puedes usar el comando ./mvnw spring-boot:run o ejecutar la clase ForoApplication desde tu IDE (IntelliJ).

Migraciones:

Flyway se encargará de crear las tablas de usuarios y topicos automáticamente al iniciar.

🧪 Pruebas en Insomnia / Postman
El proyecto incluye validaciones @Valid para asegurar que los datos enviados sean correctos. Recuerda que cualquier error de sintaxis en el JSON (como una coma extra) será rechazado por el servidor.

👤 Autor
Desarrollado por Vulfka-Lid como parte del programa Oracle Next Education (ONE).

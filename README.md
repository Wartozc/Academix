# Academix BACKEND

**Academix** es una aplicación backend reactiva construida con **Spring WebFlux**, diseñada para la gestión de usuarios. Expone un conjunto de endpoints RESTful versionados y autodocumentados mediante Swagger (OpenAPI 3).

## 🌐 Base Path

Todos los endpoints están expuestos bajo el siguiente base path:

```
/api/v1/academix
```

## 🚀 Tecnologías

- Java 21
- Spring Boot 3
- Spring WebFlux
- Springdoc OpenAPI (Swagger)
- DynamoDB
- Docker-ready (opcional)
- Gradle

## 📦 Endpoints disponibles

### 1. Health check

Verifica que el backend esté funcionando correctamente.

```bash
curl --location 'http://localhost:8080/api/v1/academix/health'
```

- **Método:** `GET`
- **Respuesta:** `200 OK`

---

### 2. Crear usuario

```bash
curl --location 'http://localhost:8080/api/v1/academix/user' --header 'Content-Type: application/json' --data-raw '{
  "name": "Sandra Milena",
  "documentType": "CC",
  "documentNumber": "15465165165",
  "age": "40",
  "email": "Milena@gmail.com",
  "password": "Sandra1994*",
  "rol": "USER"
}'
```

- **Método:** `POST`
- **Headers:** `document-number` obligatorio
- **Body:** JSON
- **Respuesta:** `201 Created`

---

### 3. Actualizar usuario

```bash
curl --location --request PUT 'http://localhost:8080/api/v1/academix/user/{id}' --header 'Content-Type: application/json' --data-raw '{
  "name": "Walther Zapata",
  "documentType": "CC",
  "documentNumber": "5555555555",
  "age": "30",
  "email": "wart@gmail.com",
  "password": "Walterzc1994*",
  "rol": "USER"
}'
```

- **Método:** `PUT`
- **PathVariable:** `id`
- **Body:** JSON
- **Respuesta:** `200 OK`

---

### 4. Listar usuarios

```bash
curl --location 'http://localhost:8080/api/v1/academix/users' --header 'user-admin: admin123456789'
```

- **Método:** `GET`
- **Header obligatorio:** `user-admin`
- **Respuesta:** `200 OK`, lista de usuarios

---

### 5. Eliminar usuario

```bash
curl --location --request DELETE 'http://localhost:8080/api/v1/academix/user/{id}'
```

- **Método:** `DELETE`
- **PathVariable:** `id`
- **Respuesta:** `204 No Content`

---

## 🧾 Documentación Swagger

El Swagger UI está expuesto para facilitar la prueba y exploración de la API:

```
http://localhost:8080/doc/swagger-ui/index.html
```

> **NOTA:** Asegúrate de que la propiedad `springdoc.swagger-ui.path` esté correctamente configurada en `application.yaml`.

## ⚙️ Configuración

Variables de entorno configurables:

```yaml
server:
  port: ${SERVER_PORT:8080}

spring:
  application:
    name: ${APP_NAME:Academix}
  webflux:
    base-path: ${BASE_PATH:/api/v1/academix}
  profiles:
    include: ${ENV:local}

springdoc:
  api-docs:
    path: /doc/api-docs
  swagger-ui:
    path: /doc/swagger-ui/index.html
    config-url: /api/v1/academix/doc/api-docs

app:
  adapters:
    dynamodb:
      table-name: ${USER_TABLE:users}
      admin-id: ${ADMIN_ID:admin123456789}
```

## 🧪 Pruebas

Puedes probar todos los endpoints directamente desde Swagger o usando herramientas como Postman o `curl`.

## 📁 Estructura de código relevante

```
├── application
    └── app-service
├── domain
    └── usecase
    └── model
├── infrastructure
    └── entry-points
    ├   └── reactive-web
    └── driven-adapters
    ├   └── dynamodb
    └── helpers
```

## 🛡️ Seguridad

Actualmente no hay autenticación OAuth2 ni JWT. La autorización se hace por headers simples como `user-admin`, pero puede escalarse fácilmente.

---

## 🧩 Extensiones posibles

- Autenticación JWT
- Seguridad con roles y permisos
- Paginación y filtrado de usuarios
- Tests con WebTestClient
- Integración continua

---

### 📄 Documentación OpenAPI

Puedes descargar el archivo Swagger aquí:

[📥 Descargar swagger_academix.json](./swagger_academix.json)

#### 🔍 Visualiza la API en Swagger Editor

Puedes copiar el contenido de `swagger_academix.json` y pegarlo en [Swagger Editor](https://editor.swagger.io/) para una vista interactiva.

O bien, abre directamente el archivo localmente en el editor:
1. Ve a [Swagger Editor](https://editor.swagger.io/)
2. Haz clic en **File → Import File**
3. Selecciona `swagger_academix.json`


### 📄 Colección de POSTMAN

Puedes descargar la colección de postMan para probar el servicio en local:

[📥 Descargar Academix.postman_collection.json](./Academix.postman_collection.json)

## 👨‍💻 Autor

Este backend fue desarrollado como parte de un sistema modular con enfoque reactivo y arquitectura limpia.

# Academix FRONTEND

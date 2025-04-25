# ms-clients
Microservicio de demostración para la vacante de Backend Java Developer en SEEK.

# 🧠 Sistema de Gestión de Clientes - Microservicio Java + Spring Boot

Este microservicio permite gestionar clientes dentro de un proceso de selección y contratación. Expone endpoints REST para registrar clientes, calcular métricas y listar información relevante.

---

## 🚀 Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3+**
- **Spring Data JPA + MySQL**
- **Spring Security + JWT**
- **Lombok**
- **Flyway**
- **Docker + Docker Compose**
- **Swagger / OpenAPI**
- **AWS EC2 para despliegue**

---

## 🔧 Funcionalidades principales

- ✅ Crear nuevos clientes (nombre, apellido, edad, fecha de nacimiento)
- 📊 Calcular métricas de edad: **promedio** y **desviación estándar**
- 📅 Calcular esperanza de vida estimada para cada cliente
- 🔐 Seguridad basada en JWT
- 📈 Exposición de métricas y monitoreo
- 📄 Documentación Swagger
- 📦 Persistencia con MySQL

---

## 📦 Estructura del Proyecto
src/
├── config/ -> Seguridad, JWT, Beans
├── controller/ -> Endpoints REST
├── domain/ ->
    ├── dto/ -> Request/Response DTOs
    └── entity/ -> Entidades JPA
├── repository/ -> Interfaces JPA
├── service/ -> Lógica de negocio
├── exception/ -> Manejo de errores
└── MainApp.java -> Clase principal

---

## 🛠️ Cómo correr el proyecto
docker-compose up --build -d

Esto iniciará:
- MySQL en el puerto 3306
- ms-clients en http://localhost:8096

---

## 🔐 Variables de entorno (.env)

- SPRING_PROFILES_ACTIVE=docker
- SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/seek_demo
- SPRING_DATASOURCE_USERNAME=admin
- SPRING_DATASOURCE_PASSWORD=h0l4Mund0
- JWT_SECRET=b205cbcbed3aa08c25c4cc051840569f023a571b7f74c1c8b6f0dd94bf12f0d17535103c587f2e2cd9e263ca1b93253d7cb955c00d57a97b1087666ca947874bf09073947cf0a1e28f5a21d7603006a9265349d3cccb89884d262f6be415e24df61276e1d80dc42e3f8d66f48a043c565e33a6bee0657a57d164aedfde8cacf5b66739d8be9b0f1789affb7087f088a1b54d37277305444f0fd8d53dda97dc3ba82ee15a8f45615ff43c5b1a8a7c8fc27d976d6d8de9784445f8871176b84a5054360dffbd586d2aeaf635f5a5427e9ce0d37ed6b46f9c63795371d1b221369afba969df39e88be212bc031ce36be185d9c69f9e9eec8f6bdde34d794dd2f952

--- 

## 🔍 Documentación API (Swagger)
http://localhost:8096/swagger-ui/index.html

---

## 👤 Autor
Desarrollado por: **Wendy Gabriela Cobo Burelo**

📧 _gaby.burelo@outlook.com_

🌐 _https://linkedin.com/in/gburelo94_






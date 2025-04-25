# Imagen base con Java 21
FROM openjdk:21-jdk-slim

# JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

RUN echo $JAVA_HOME
RUN java -version

# Directorio de trabajo
WORKDIR /app

# Copiamos el archivo .jar generado localmente
COPY build/libs/ms-clients-0.0.1-SNAPSHOT.jar ms-clients.jar

# Exponemos el puerto 8096
EXPOSE 8096

# Establecemos la variable de entorno para el perfil de Spring
ENV SPRING_PROFILES_ACTIVE=docker

# Etiquetas del contenedor
LABEL maintainer="Gaby Burelo <gaby.burelo@outlook.com>"
LABEL version="1.0.0"
LABEL description="Microservicio de gestión de clientes"

# Comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-Dspring.profiles.active=$SPRING_PROFILES_ACTIVE", "-jar", "ms-clients.jar"]

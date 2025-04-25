# Imagen base con Java 21
FROM openjdk:21-jdk-slim

# Argumento para poner nombre al jar
ARG JAR_FILE=ms-clients.jar
ENV APP_NAME=${JAR_FILE}

# Carpeta de trabajo
WORKDIR /app

# Copiamos el .jar generado localmente
COPY build/libs/*.jar ${APP_NAME}

# Puerto donde se va a exponer
EXPOSE 8096

# Variables de entorno
ENV SPRING_PROFILES_ACTIVE=docker
ENV JAVA_OPTS=""

# Etiquetas
LABEL maintainer="Gaby Burelo <gaby.burelo@outlook.com>"
LABEL version="1.0.0"
LABEL description="Microservicio de gestión de clientes"

# Entrada para admitir perfiles y opciones adicionales
ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar $APP_NAME

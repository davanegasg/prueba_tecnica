# Usamos la imagen de OpenJDK
FROM openjdk:21-jdk-slim

# Copiamos el archivo JAR de nuestra aplicación
COPY target/crud-0.0.1-SNAPSHOT.jar app.jar

# Instalar netcat
RUN apt-get update && apt-get install -y netcat

# Exponemos el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Ejecutamos el archivo JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]

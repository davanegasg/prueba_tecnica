# Prueba_Tecnica Sivar

## Contexto

### Se requiere crear una relación entre tablas, donde requiero tener usuarios (con información basica del usuario), y que cada usuario pueda tener una o multiples Empresas (información basica de empresa, nombre, nit) y para cada empresa el usuario va a tener un rol especifico. Por cada empresa tener puntos de venta(informacion de direccion, y nombre). Considerar que cada empresa puede tener asociado varios usuarios y cada Punto de venta puede estar asociado a varias empresas y no se deben repetir las empresas ni los puntos de venta en las tablas.

# Nombre del Proyecto

## Descripción

Una breve descripción del proyecto y su propósito.

---

## Requisitos previos

Antes de ejecutar el proyecto en tu PC, asegúrate de tener instalados los siguientes programas:

- **Java 21**: [Instalar Java 21](https://jdk.java.net/21/)
- **Maven**: [Instalar Maven](https://maven.apache.org/install.html)

---

## Clonar el repositorio

1. Abre una terminal en tu PC.
2. Navega al directorio donde deseas clonar el repositorio.
3. Ejecuta el siguiente comando para clonar el repositorio:

   ```bash
   git clone https://github.com/usuario/nombre-del-repositorio.git

4. Accede al directorio del proyecto clonado:

   ```bash
   cd nombre-del-repositorio

## Instalación

1. Asegúrate de que Java 21 y Maven estén instalados en tu sistema.

2. Instala las dependencias del proyecto. Ejecuta el siguiente comando en la terminal dentro del directorio del proyecto:

   ```bash
   mvn clean install

## Ejecutar la aplicación usando Docker

Para correr la aplicación dentro de un contenedor Docker, sigue estos pasos:

### 1. Requisitos previos

Antes de ejecutar el proyecto en Docker, asegúrate de tener instalado **Docker** en tu máquina. Si no lo tienes, puedes descargarlo desde [aquí](https://www.docker.com/products/docker-desktop).

### 2. Construir la imagen Docker

En el directorio raíz de tu proyecto, asegúrate de tener un archivo `Dockerfile` que contenga la configuración necesaria para construir la imagen Docker. Si no tienes un `Dockerfile`, aquí tienes un ejemplo básico para una aplicación Spring Boot:

    ```Dockerfile
    # Usar una imagen base de Java 21
    FROM openjdk:21-jdk-slim

    # Establecer el directorio de trabajo
    WORKDIR /app

    # Copiar el archivo JAR de la aplicación al contenedor
    COPY target/mi-aplicacion.jar /app/mi-aplicacion.jar

    # Exponer el puerto que usará la aplicación
    EXPOSE 8080

    # Comando para ejecutar la aplicación
    ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]

    ```Dockercompose

    docker-compose up --build

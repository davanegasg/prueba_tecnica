# Prueba_Tecnica Sivar

## Contexto

### Se requiere crear una relación entre tablas, donde requiero tener usuarios (con información basica del usuario), y que cada usuario pueda tener una o multiples Empresas (información basica de empresa, nombre, nit) y para cada empresa el usuario va a tener un rol especifico. Por cada empresa tener puntos de venta(informacion de direccion, y nombre). Considerar que cada empresa puede tener asociado varios usuarios y cada Punto de venta puede estar asociado a varias empresas y no se deben repetir las empresas ni los puntos de venta en las tablas

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
   git clone https://github.com/davanegasg/prueba_tecnica.git

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

### 2. Construir la imagen Docker usando docker compose

Asegurate de tener un .jar


    ```Dockercompose
    mvn clean package

    docker-compose up --build
    ```

# API Endpoints

## User Endpoints

| **Método** | **Endpoint**                | **Descripción**                                        | **Parámetros**               | **Respuesta**                            |
|------------|-----------------------------|--------------------------------------------------------|------------------------------|------------------------------------------|
| `GET`      | `/api/v1/users`             | Obtiene la lista de todos los usuarios.                | -                            | 200 OK: Lista de usuarios.              |
| `GET`      | `/api/v1/users/{id}`        | Obtiene los detalles de un usuario por su ID.          | `id` (path): ID del usuario.  | 200 OK: Detalles del usuario.           |
| `POST`     | `/api/v1/users`             | Crea un nuevo usuario.                                 | `nombre`, `email`, `rol`      | 201 Created: Usuario creado.            |
| `DELETE`   | `/api/v1/users/{id}`        | Elimina un usuario por su ID.                          | `id` (path): ID del usuario.  | 204 No Content: Usuario eliminado.      |

---

## CompanyPuntoVenta Endpoints

| **Método** | **Endpoint**                     | **Descripción**                                        | **Parámetros**               | **Respuesta**                            |
|------------|-----------------------------------|--------------------------------------------------------|------------------------------|------------------------------------------|
| `POST`     | `/api/v1/company_punto_venta`     | Asocia un Punto de Venta con una Empresa.              | `companyId`, `puntoVentaId`  | 200 OK: Relación creada.                |
| `PUT`      | `/api/v1/company_punto_venta/{id}`| Actualiza la relación entre Empresa y Punto de Venta.   | `id` (path): ID de la relación| 200 OK: Relación actualizada.            |
| `GET`      | `/api/v1/company_punto_venta/company/{companyId}`  | Obtiene los Puntos de Venta de una Empresa.            | `companyId` (path): ID de la empresa | 200 OK: Lista de Puntos de Venta.  |
| `GET`      | `/api/v1/company_punto_venta/punto_de_venta/{puntoVentaId}` | Obtiene las Empresas asociadas a un Punto de Venta.   | `puntoVentaId` (path): ID del Punto de Venta | 200 OK: Lista de Empresas. |
| `DELETE`   | `/api/v1/company_punto_venta/{id}`| Elimina la relación entre Empresa y Punto de Venta.     | `id` (path): ID de la relación | 204 No Content: Relación eliminada. |

---

## PuntoVenta Endpoints

| **Método** | **Endpoint**             | **Descripción**                                        | **Parámetros**               | **Respuesta**                            |
|------------|--------------------------|--------------------------------------------------------|------------------------------|------------------------------------------|
| `GET`      | `/api/v1/puntoVenta`     | Obtiene la lista de todos los Puntos de Venta.         | -                            | 200 OK: Lista de Puntos de Venta.        |
| `GET`      | `/api/v1/puntoVenta/{id}`| Obtiene los detalles de un Punto de Venta por su ID.   | `id` (path): ID del Punto de Venta | 200 OK: Detalles del Punto de Venta. |
| `POST`     | `/api/v1/puntoVenta`     | Crea un nuevo Punto de Venta.                          | `nombre`, `ubicacion`         | 201 Created: Punto de Venta creado.      |
| `DELETE`   | `/api/v1/puntoVenta/{id}`| Elimina un Punto de Venta por su ID.                   | `id` (path): ID del Punto de Venta | 204 No Content: Punto de Venta eliminado. |

---

## Rol Endpoints

| **Método** | **Endpoint**           | **Descripción**                                        | **Parámetros**               | **Respuesta**                            |
|------------|------------------------|--------------------------------------------------------|------------------------------|------------------------------------------|
| `GET`      | `/api/v1/roles`         | Obtiene la lista de todos los roles.                   | -                            | 200 OK: Lista de roles.                 |
| `GET`      | `/api/v1/roles/{id}`    | Obtiene los detalles de un rol por su ID.              | `id` (path): ID del rol.      | 200 OK: Detalles del rol.               |
| `POST`     | `/api/v1/roles`         | Crea un nuevo rol.                                     | `nombre`, `descripcion`       | 201 Created: Rol creado.                |
| `DELETE`   | `/api/v1/roles/{id}`    | Elimina un rol por su ID.                              | `id` (path): ID del rol.      | 204 No Content: Rol eliminado.          |

---

## Company Endpoints

| **Método** | **Endpoint**             | **Descripción**                                        | **Parámetros**               | **Respuesta**                            |
|------------|--------------------------|--------------------------------------------------------|------------------------------|------------------------------------------|
| `GET`      | `/api/v1/companies`       | Obtiene la lista de todas las empresas.                | -                            | 200 OK: Lista de empresas.               |
| `GET`      | `/api/v1/companies/{id}`  | Obtiene los detalles de una empresa por su ID.         | `id` (path): ID de la empresa | 200 OK: Detalles de la empresa.          |
| `POST`     | `/api/v1/companies`       | Crea una nueva empresa.                                | `nombre`, `direccion`         | 201 Created: Empresa creada.             |
| `DELETE`   | `/api/v1/companies/{id}`  | Elimina una empresa por su ID.                         | `id` (path): ID de la empresa | 204 No Content: Empresa eliminada.       |
---
## Company Users Endpoints

| Endpoint                             | Método HTTP | Descripción                                                                 | Request Body                                                                                      | Response Body                                                                                             | Código de Estado                |
|--------------------------------------|-------------|-----------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|---------------------------------|
| `/api/v1/user_company`               | `POST`      | Asocia un usuario a una empresa con un rol especificado.                    | `{ "userId": Integer, "companyId": Integer, "rolId": Integer }`                                  | `{ "userId": Integer, "companyId": Integer, "rolId": Integer }`                                          | `200 OK` / `400 Bad Request`     |
| `/api/v1/user_company/{id}`          | `PUT`       | Actualiza la relación entre un usuario, una empresa y un rol.               | `{ "userId": Integer, "companyId": Integer, "rolId": Integer }`                                  | `{ "userId": Integer, "companyId": Integer, "rolId": Integer }`                                          | `200 OK` / `404 Not Found`       |
| `/api/v1/user_company/company/{companyId}` | `GET`       | Obtiene la lista de relaciones de usuarios asociadas a una empresa.         | N/A                                                                                               | `List<UserCompany>`                                                                                      | `200 OK`                         |
| `/api/v1/user_company/user/{userId}` | `GET`       | Obtiene la lista de relaciones de empresas asociadas a un usuario.          | N/A                                                                                               | `List<UserCompany>`                                                                                      | `200 OK`                         |
| `/api/v1/user_company/{id}`          | `DELETE`    | Elimina la relación de usuario con la empresa especificada.                 | N/A                                                                                               | `No Content`                                                                                             | `204 No Content`                 |


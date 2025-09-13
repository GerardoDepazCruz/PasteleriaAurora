# 🛒 Aplicativo Web Para la Pasteleria Aurora – Proyecto De Herramientas de Desarrollo
---
## 📘 Descripción del Proyecto
La pastelería Aurora presenta dificultades en la gestión integral de sus operaciones debido al uso de procesos manuales poco eficientes. Actualmente, la toma de pedidos, el control del inventario y la atención al cliente se realizan sin un sistema centralizado, lo que genera errores frecuentes en los pedidos, retrasos en las entregas y desconocimiento sobre la disponibilidad real de productos.

Asimismo, los clientes carecen de una plataforma digital que les permita visualizar el catálogo, personalizar productos según sus preferencias o recibir notificaciones sobre el estado de sus pedidos. Esta carencia tecnológica reduce la experiencia del cliente, limita el alcance del negocio a nivel competitivo y sobrecarga al personal con tareas operativas repetitivas.

En consecuencia, la falta de automatización frena el crecimiento sostenible de la empresa, disminuye la satisfacción del cliente y afecta la capacidad de la pastelería para adaptarse a las nuevas demandas del mercado.

## Tecnologias usadas





## Instalación y Ejecución

1. Instalar Java Development Kit (JDK 17 o superior). <https://www.oracle.com/java/technologies/downloads/>

y luego verificar en el cmd con:
```bash
java -version
```

2. Instalar Maven. <https://maven.apache.org/download.cgi>

y luego verificar en el cmd con:
```bash
mvn -v
```

3. Instalar un IDE compatible. <https://code.visualstudio.com/download>
4. Ingresar a Spring Initializr y crear un proyecto <https://start.spring.io/>
5. Descargar y abrir el proyecto en el IDE.
6. Configurar el archivo application.properties con la conexión a la base de datos MySQL
```bash
//BD
spring.datasource.url=jdbc:mysql://localhost:3306/pasteleria
spring.datasource.username=Pasteleria
spring.datasource.password=pasteleriagera

//JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
```
7. Crear las entidades, repositorios, servicios y controladores necesarios.
8. Diseñar las páginas HTML en la carpeta src/main/resources/templates (usando Thymeleaf).
9. Ejecutar el proyecto con:
```bash
mvn spring-boot:run
```
10.Abrir el navegador en <http://localhost:8080> para ver la aplicación funcionando.



## Roles y Crédito

| Nombre   | Rol                          | Funciones                                                                 |
|----------|------------------------------|----------------------------------------------------------------------------|
| Gerardo  | **Líder y Desarrollador Backend**       | Coordinar al equipo, definir tareas, integrar módulos, supervisar avances y velar por la seguridad de la aplicación |
| Ana      | **Desarrolladora Frontend**  | Diseñar interfaces en HTML, estructurar formularios y vistas del sistema, asegurar la usabilidad y experiencia del usuario |
| Alexander| **Responsable de Versiones** | Configurar Git/GitHub, gestionar ramas, merge y resolver conflictos, mantener la integridad del repositorio |
| Josue    | **Desarrollador Backend**    | Implementar lógica con Spring Boot, crear controladores y servicios, garantizar la eficiencia y escalabilidad del sistema |
| Jennifer | **Encargada de la Base de Datos** | Crear y gestionar la base en MySQL, modelar tablas y relaciones, seguridad de datos con encriptación y respaldo de la información |


## Flujo de Trabajo en Git






## Capturas de Pantalla

### **USUARIO**

#### **Inicio**
![Incio](img/Inicio_Usuario.png)

#### **Lista de Productos**
![Productos](img/Catalogo_Usuario.png)

#### **Carrito de Compras**
![Carrito](img/Carrito_Usuario.png)

#### **Pedidos personalizado**
![Personalizado](img/Personalizado_Usuario.png)

#### **Nosotros**
![Nosotros](img/Nosotros_Usuario.png)

#### **Iniciar sesion y Crear Cuenta**
![IniciarSesion](img/InicioDeSesion_Usuario.png)
![CrearCuenta](img/CrearCuenta_Usuario.png)


### **ADMINISTRADOR**

#### **Gestionar productos**
![GestionarProductos](img/GestionarProductos_Admin.png)
![GestionarProductosFormulario](img/GestionarProductosFormulario_Admin.png)

#### **Lista de usuarios**
![ListaDeUsuarios](img/ListaUsuarios_Admin.png)

#### **Los pedidos**
![Pedidos](img/Pedidos_Admin.png)

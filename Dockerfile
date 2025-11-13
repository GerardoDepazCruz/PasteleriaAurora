# Usar imagen oficial de Maven para construir la app
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copiar pom.xml y bajar dependencias
COPY pom.xml .

RUN mvn dependency:go-offline

# Copiar código fuente y construir la aplicación
COPY src ./src

RUN mvn clean package -DskipTests

# Usar imagen de OpenJDK para ejecutar la app
FROM openjdk:17-jdk

WORKDIR /app

# Copiar el .jar construido
COPY --from=build /app/target/*.jar app.jar

# Exponer puerto 8080 (o el que uses)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java","-jar","app.jar"]

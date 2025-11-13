# -------- STAGE 1: BUILD --------
FROM maven:3.9.8-eclipse-temurin-21 AS builder

WORKDIR /app

# Copiamos el pom y descargamos dependencias (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos todo el proyecto
COPY . .

# Compilamos y generamos el JAR
RUN mvn clean package -DskipTests


# -------- STAGE 2: RUN --------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiamos el JAR desde el stage anterior
COPY --from=builder /app/target/*.jar app.jar

# Render asigna el puerto dinámicamente
ENV PORT=8080

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]

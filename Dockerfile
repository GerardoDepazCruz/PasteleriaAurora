# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Carpeta del contenedor
WORKDIR /app

# Copiar JAR generado por Maven
COPY target/PasteleriaAurora-0.0.1-SNAPSHOT.jar app.jar

# Render define el PORT automáticamente.
# Debemos pasar ese PORT a Spring Boot dentro del contenedor.
ENV PORT=8080

# Exponer el puerto
EXPOSE 8080

# Comando de ejecución usando la variable de PORT
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]

FROM eclipse-temurin:26-jdk

WORKDIR /app
COPY . .
RUN ./gradlew build
RUN cp build/libs/app-0.0.1-SNAPSHOT.jar /app.jar

ENV SPRING_PROFILES_ACTIVE=prd
ENTRYPOINT ["java","-jar","/app.jar"]
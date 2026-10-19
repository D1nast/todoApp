FROM eclipse-temurin:26-jdk
ENV SPRING_PROFILES_ACTIVE=prd
EXPOSE 10000

COPY build/libs/app-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
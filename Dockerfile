FROM gradle:8.7-alpine AS BUILDER
WORKDIR /usr/app/
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build --no-daemon -x test

FROM amazoncorretto:17-alpine
ENV APP_HOME=/usr/app
ENV JAR_FILE=auth-client-0.0.1-SNAPSHOT.jar
WORKDIR $APP_HOME
COPY --from=BUILDER $APP_HOME/build/libs/$JAR_FILE .
EXPOSE 8080
ENTRYPOINT java -jar $JAR_FILE
# build custom JRE
FROM openjdk:14-alpine AS jre-build
WORKDIR /app

RUN jlink --verbose \
--compress 2 \
--strip-java-debug-attributes \
--no-header-files \
--no-man-pages \
--output jre \
--add-modules java.base\
,java.logging\
,java.xml\
,jdk.unsupported\
,java.sql\
,java.naming\
,java.desktop\
,java.management\
,java.security.jgss\
,java.instrument

# start from gradle build image
FROM jre-build AS build
WORKDIR /app

# copy gradle only files over
COPY gradlew gradlew
COPY gradle/ gradle/
RUN ./gradlew --version

# copy project build files over
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY gradle.properties gradle.properties

# download dependencies only
RUN ./gradlew downloadDependencies

# copy full solution and build
COPY . .
RUN ./gradlew build

# take a smaller runtime image for the final output
FROM alpine:latest

COPY --from=jre-build /app/jre /jre
COPY --from=build /app/build/libs/helloservice-0.0.1.jar /app.jar

ENV SPRING_PROFILE=default
ENV JAVA_TOOL_OPTIONS=

EXPOSE 4000
ENTRYPOINT /jre/bin/java -Dspring.profiles.active=$SPRING_PROFILE -jar app.jar

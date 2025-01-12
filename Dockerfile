FROM public.ecr.aws/bitnami/node:22 as webBuild
WORKDIR /tmp
COPY ./frontend ./frontend
WORKDIR /tmp/frontend
RUN npm install
RUN npm run build

FROM gradle:jdk21 as serverBuild
WORKDIR /tmp
COPY ./backend ./backend
WORKDIR /tmp/backend
COPY --from=webBuild /tmp/frontend/dist /tmp/backend/src/main/resources/static
RUN ./gradlew wrapper --gradle-version 8.8 --distribution-type all
RUN ./gradlew build -x test

FROM public.ecr.aws/docker/library/openjdk:21-jdk
ARG SPRING_PROFILES_ACTIVE
ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE}

COPY --from=serverBuild /tmp/backend/build/libs/backend-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD java -Ddebug -jar app.jar --spring.profiles.active=${SPRING_PROFILES_ACTIVE}

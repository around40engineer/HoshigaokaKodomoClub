FROM public.ecr.aws/bitnami/node:16 as webBuild
WORKDIR /tmp
COPY ./frontend ./frontend
WORKDIR /tmp/frontend
RUN yarn install
RUN yarn build

FROM public.ecr.aws/bitnami/gradle:7 as serverBuild
WORKDIR /tmp
COPY ./backend ./backend
WORKDIR /tmp/backend
COPY --from=webBuild /tmp/frontend/dist /tmp/backend/src/main/resources/static
RUN ./gradlew build -x test

FROM public.ecr.aws/docker/library/openjdk:17-jdk
ARG SPRING_PROFILE
ENV SPRING_PROFILE ${SPRING_PROFILE}

COPY --from=serverBuild /tmp/server/build/libs/backend-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD java -jar app.jar --spring.profiles.active=${SPRING_PROFILE}

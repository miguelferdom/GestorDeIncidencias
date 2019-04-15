FROM maven as builder
COPY . /code/
WORKDIR /code
RUN mvn -DskipTests=true package

FROM openjdk:8-jre
RUN apt-get update; apt-get install -y netcat
COPY --from=builder /code/target/*.jar /usr/app/
COPY ./run.sh /usr/app/
WORKDIR /usr/app
RUN chmod 777 /usr/app/run.sh
CMD ["/usr/app/run.sh"]
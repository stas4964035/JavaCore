FROM openjdk:latest
WORKDIR /usr/src/app
COPY ./src/main/java .
RUN javac -sourcepath . -d out ./ru/geekbrains/core/lesson1/task1/Program.java
WORKDIR /usr/src/app/out
CMD java -classpath . ru.geekbrains.core.lesson1.task1.Program

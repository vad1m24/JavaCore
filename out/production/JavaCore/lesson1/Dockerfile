FROM bellsoft/liberica-openjdk-alpine:latest
COPY ./task1 ./java
RUN mkdir ./out
RUN apk add --no-cache bash
RUN javac -encoding ISO-8859-1 -sourcepath ./java -d out java/sample/Main.java
RUN java -classpath ./out sample.main

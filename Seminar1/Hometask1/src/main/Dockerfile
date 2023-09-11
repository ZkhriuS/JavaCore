FROM bellsoft/liberica-openjdk-alpine:11.0.16
COPY ./java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d ./out ./src/sample/Main.java
CMD java -classpath ./out sample.Main
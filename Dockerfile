FROM java:9
WORKDIR /
ADD build/foobarqix-1.0-spring-boot.jar app.jar
CMD java -jar app.jar